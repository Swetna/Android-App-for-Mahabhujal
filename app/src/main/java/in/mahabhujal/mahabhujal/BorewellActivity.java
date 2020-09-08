package in.mahabhujal.mahabhujal;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class BorewellActivity extends AppCompatActivity {

    private TextView b_add_data;
    public Button b_regform;
    public Button b_waterlevel;
    public Button b_waterstruct;
    public Button b_sect;
    public Button b_phours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_borewell);

        b_add_data = (TextView) findViewById(R.id.b_add_data);
        b_regform = (Button) findViewById(R.id  .but_registerborewell);
        b_waterlevel = (Button) findViewById(R.id.b_water_level);
        b_waterstruct = (Button) findViewById(R.id.b_water_struct_level);
        b_sect = (Button) findViewById(R.id.b_section);
        b_phours = (Button) findViewById(R.id.b_phours);



        //       b_regform.setOnClickListener(this);
    }

public void actionclick(View view){

        Log.i("Nilesh","success");


    Toast t = Toast.makeText(this, "Check 1", Toast.LENGTH_LONG);
    t.show();
}

//    @Override
//    public void onClick(View v) {
//        Log.i(" nilesh","Clicked");
//        switch (v.getId()) {
//
//            case R.id.but_registerborewell:
//              Log.i(" nilesh","Clicked");
//              Toast t=Toast.makeText(this,"Check 1",Toast.LENGTH_LONG);
//              t.show();
////            Intent intent = (new Intent(getApplicationContext(),BorewellFormActivity.class));
////            startActivity(intent);
//            break;
//        }
//
//    }
}