package in.mahabhujal.mahabhujal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class WellActivity extends AppCompatActivity {

    private TextView w_add_data;
    public Button w_regform ;
    public Button  w_waterlevel;
    public Button  w_waterstruct;
    public Button  w_sect;
    public Button  w_phours;
    public Button  w_ptest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well);

        w_add_data=(TextView) findViewById(R.id.w_add_data);
        w_regform=(Button) findViewById(R.id.but_registerwell);
        w_waterlevel=(Button) findViewById(R.id.w_water_level);
        w_waterstruct=(Button) findViewById(R.id.w_water_struct_level);
        w_sect=(Button) findViewById(R.id.w_section);
        w_phours=(Button) findViewById(R.id.w_phours);
        w_ptest=(Button) findViewById(R.id.w_ptest);


        w_regform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_wellForm(view);
               // Intent intent=new Intent(WellActivity.this,WellFormActivity.class);
                //startActivity(intent);
            }
        });

    }

    public void btn_wellForm(View view) {
        //startActivity(new Intent(getApplicationContext(), WellFormActivity.class));
        Intent i = (new Intent(getApplicationContext(), BorewellFormActivity.class));
        startActivity(i);
    }
    // public void openWellForm(){
     //   Intent intent=new Intent(WellActivity.this,WellFormActivity.class);
       // startActivity(intent);}
}