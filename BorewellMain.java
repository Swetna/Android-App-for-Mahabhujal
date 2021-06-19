package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BorewellMain extends AppCompatActivity {

    Button but_regborewell;
    Button borewell_water_struct;
    Button borewell_level;
    Button borewell_section;
    Button borewell_pumping_hrs;
    //Button borewell_pumping_test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_main);



        but_regborewell = findViewById(R.id.but_registerborewell);
        borewell_water_struct = findViewById(R.id.b_water_struct);
        borewell_level = findViewById(R.id.b_water_level);
        borewell_section = findViewById(R.id.bore_sect);
        borewell_pumping_hrs = findViewById(R.id.b_pump_hrs);
        //borewell_pumping_test = findViewById(R.id.pumping_test);

        but_regborewell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = (new Intent(BorewellMain.this, BorewellFormActivity.class));
                startActivity(intent1);
            }
        });


        borewell_water_struct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = (new Intent(BorewellMain.this, BorewellStruct.class));
                startActivity(intent2);
            }
        });

        borewell_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = (new Intent(BorewellMain.this, BorewellLevel.class));
                startActivity(intent3);
            }
        });
        borewell_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = (new Intent(BorewellMain.this, BorewellSection.class));
                startActivity(intent4);
            }
        });
        borewell_pumping_hrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = (new Intent(BorewellMain.this, BorewellPumpHrs.class));
                startActivity(intent5);
            }
        });
        //pumping_test.setOnClickListener(this);



    }


}