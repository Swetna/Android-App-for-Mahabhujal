package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WaterQualityMain extends AppCompatActivity {
Button but_water_quality_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_water_qualty);


        but_water_quality_data= findViewById(R.id.but_water_quality_data);


        but_water_quality_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = (new Intent(WaterQualityMain.this, WaterQualityData.class));
                startActivity(intent1);
            }
        });




    }
}