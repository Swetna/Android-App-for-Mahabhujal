package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.model.Users;
import in.mahabhujal.mahabhujal.registration.PostApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Registration extends AppCompatActivity {

    //SQLiteOpenHelper openHelperUsers;
    //SQLiteDatabase db;


    private EditText username;
    private EditText first_name;
    private EditText last_name;
    private EditText email_address;
    private EditText password;
    private EditText repeat_password;
    TextView have_account;
    Button RegisterUser;

    boolean isAllFieldsChecked = false;

    String url = "http://dbitbeproject.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //openHelperUsers = new DatabaseHelperRegister(this);

        have_account = (TextView) findViewById(R.id.having_account);
        have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Registration.this, MainLogin.class);
                startActivity(intent1);

            }
        });


        username = (EditText) findViewById(R.id.reg_username);
        first_name = (EditText) findViewById(R.id.reg_firstname);
        last_name = (EditText) findViewById(R.id.reg_lastname);
        email_address = (EditText) findViewById(R.id.register_EmailAddress);
        password = (EditText) findViewById(R.id.Password);
        repeat_password = (EditText) findViewById(R.id.Repeat_Password);
        RegisterUser = (Button) findViewById(R.id.but_register_form);


        String Username = username.getText().toString();
        String Firstname = first_name.getText().toString();
        String Lastname = last_name.getText().toString();
        String Emailid = email_address.getText().toString();
        String Password = password.getText().toString();


        RegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process();


                //db = openHelperUsers.getWritableDatabase();

                String Username = username.getText().toString();
                String Firstname = first_name.getText().toString();
                String Lastname = last_name.getText().toString();
                String Emailid = email_address.getText().toString();
                String Password = password.getText().toString();

                /*
                insertdatareg(Username,Firstname,Lastname,Emailid,Password);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();
*/


            }
        });


        while (Username.isEmpty()) {
            username.setError("Enter Valid username");
            username.requestFocus();
            //return;

            while (Password.isEmpty()) {
                password.setError("InValid Password");
                password.requestFocus();

                while ((!repeat_password.equals(password))){
                    repeat_password.setError("Repeated password does not match");


                while (Emailid.isEmpty()) {
                    email_address.setError("Enter Valid username");
                    email_address.requestFocus();

                    while (Firstname.isEmpty()) {
                        first_name.setError("Enter Valid username");
                        first_name.requestFocus();

                        if (Lastname.isEmpty()) {
                            last_name.setError("Enter Valid username");
                            last_name.requestFocus();
                            return;
                        }
                    }

                }
                }


            }

        }
/*
    if(Password.isEmpty())
             {
                password.setError("InValid Password");
              password.requestFocus();
            return;
        }

        if (Emailid.isEmpty()) {
            email_address.setError("Enter Valid username");
            email_address.requestFocus();
            return;
        }

        if (Firstname.isEmpty()) {
            first_name.setError("Enter Valid username");
            first_name.requestFocus();
            return;
        }

        if (Lastname.isEmpty()) {
            last_name.setError("Enter Valid username");
            last_name.requestFocus();
            return;
        }

 */


    }




    private void process() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi api=retrofit.create(PostApi.class);

        Call<Users> call=api.registerUsers(username.getText().toString(),first_name.getText().toString(),last_name.getText().toString(),email_address.getText().toString(),password.getText().toString());
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                username.setText("");
                first_name.setText("");
                last_name.setText("");
                email_address.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

/*
    private void insertdatareg(String username,String firstname,String lastname,String emailid,String password) {

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelperRegister.COL_USER_1,username);
        contentValues.put(DatabaseHelperRegister.COL_USER_2,firstname);
        contentValues.put(DatabaseHelperRegister.COL_USER_3,lastname);
        contentValues.put(DatabaseHelperRegister.COL_USER_4,emailid);
        contentValues.put(DatabaseHelperRegister.COL_USER_5,password);
        long id = db.insert(DatabaseHelperRegister.TABLE_USER,null,contentValues);

    }

 */








         /*

        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   new ProfileRegister()).commit();
        }

          */
