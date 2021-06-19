package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import in.mahabhujal.mahabhujal.fingerprint.FingerprintMain;
import in.mahabhujal.mahabhujal.loginApi.ApiUtils;
import in.mahabhujal.mahabhujal.loginApi.LoginApi;
import in.mahabhujal.mahabhujal.model.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;


public class MainLogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
        SignInButton signInButton;
private GoogleApiClient googleApiClient;
        TextView textView;
    private static final int RC_SIGN_IN = 1;

    String url = "http://dbitbeproject.herokuapp.com/";

    //String url="https://mahabhujal.in/";

    TextView dont_have_account;
    TextView forgot_paassword;
    Button login,fingerprint;
    LoginApi userService;
    EditText userEmail,userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__login);

        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.social_google_auth_key))
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();





        signInButton=(SignInButton)findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });


        dont_have_account = (TextView) findViewById(R.id.dont_have_account);
        dont_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainLogin.this, Registration.class);
                startActivity(intent1);

            }
        });

        forgot_paassword = (TextView) findViewById(R.id.forgot_password);
        forgot_paassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainLogin.this, ForgotPassword.class);
                startActivity(intent1);

            }
        });


        fingerprint = (Button) findViewById(R.id.fingerprint_button);
        fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainLogin.this, FingerprintMain.class);
                startActivity(intent1);


            }
        });


        userEmail=(EditText)findViewById(R.id.email);
        userPassword=(EditText)findViewById(R.id.password);
        userService = ApiUtils.getUserService();

        login=(Button) findViewById(R.id.but_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent1 = new Intent(MainLogin.this, MainActivity.class);
                // startActivity(intent1);
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                //validate form

                //doLogin(email, password);

                if(validateLogin(email, password)){
                    //do login
                    //Toast.makeText(MainLogin.this,"Working", Toast.LENGTH_SHORT).show();
                    doLogin(email, password);
                }



            }
        });


    }

    private void doLogin(final String email, final String password) {

        Call <LoginModel> call = userService.login(email,password);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call <LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(MainLogin.this, MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();


                    LoginModel resObj = response.body();
                    if (resObj.getMessage().equals("true")) {
                        //login start main activity
                        Intent intent1 = new Intent(MainLogin.this, MainActivity.class);
                        //intent.putExtra("email", email);
                        // intent.putExtra("password", password);
                        startActivity(intent1);

                    } else {
                        Toast.makeText(MainLogin.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();// Toast.makeText(MainLogin.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }





            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
              // Toast.makeText(MainLogin.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainLogin.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainLogin.this, "Welcome to Mahabhujal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private boolean validateLogin(String email, String password) {
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount acct=result.getSignInAccount();
            String idtoken=acct.getIdToken();
            gotoProfile();


            //hideItem();
        }else{
            gotoProfile();
            //Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }


    }
    private void gotoProfile(){
        Intent intent=new Intent(MainLogin.this,MainActivity.class);
        startActivity(intent);

    }

    /*
    private void hideItem() {

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            //nav_Menu.findItem(3).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);

    }

     */
}