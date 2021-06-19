package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RainfallMain extends AppCompatActivity {
 Button rainfalldata;
 Button addrainstation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainfall_main);


        rainfalldata = findViewById(R.id.but_rainfalldata);
        addrainstation = findViewById(R.id.btn_addrainstation);

        rainfalldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = (new Intent(RainfallMain.this, RainfallDataAdd.class));
                startActivity(intent1);
            }
        });
        addrainstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = (new Intent(RainfallMain.this, RainStationData.class));
                startActivity(intent2);
            }
        });



    }
}