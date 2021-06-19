package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent1 = (new Intent(ForgotPassword.this, MainLogin.class));
        startActivity(intent1);
       // moveTaskToBack(true);

    }
}