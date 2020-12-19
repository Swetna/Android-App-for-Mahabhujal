package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateRecharge extends AppCompatActivity {
Button cal_vol,cal_need;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_recharge);

        cal_vol = findViewById(R.id.cal_vol);
        cal_need=findViewById(R.id.cal_need);

        cal_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = (new Intent(CalculateRecharge.this, CalculateVolume.class));
                startActivity(intent1);
            }
        });
        cal_need.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = (new Intent(CalculateRecharge.this, CalculateNeed.class));
                startActivity(intent2);
            }
        });

    }
}