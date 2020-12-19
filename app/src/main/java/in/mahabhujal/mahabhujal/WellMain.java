package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WellMain extends AppCompatActivity{

    Button but_regwell;
    Button water_struct;
    Button well_level;
    Button well_section;
     Button pumping_hrs;
   Button pumping_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_main);

        but_regwell = findViewById(R.id.but_registerwell);
        water_struct = findViewById(R.id.w_water_struct_level);
       well_level = findViewById(R.id.well_water_level);
        well_section = findViewById(R.id.well_section);
        pumping_hrs = findViewById(R.id.pumping_hrs);
        pumping_test = findViewById(R.id.pumping_test);

        but_regwell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = (new Intent(WellMain.this, WellFormActivity.class));
                startActivity(intent1);
            }
        });
        water_struct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = (new Intent(WellMain.this, WellStruct.class));
                startActivity(intent2);
            }
        });

        well_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= (new Intent(WellMain.this, WellWaterLevel.class));
                startActivity(intent3);
            }
        });
        well_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = (new Intent(WellMain.this, WellSection.class));
                startActivity(intent4);
            }
        });

        pumping_hrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = (new Intent(WellMain.this, WellPumpHrs.class));
                startActivity(intent5);
            }
        });


        pumping_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = (new Intent(WellMain.this, WellPumpTest.class));
                startActivity(intent6);
            }
        });




    }

}