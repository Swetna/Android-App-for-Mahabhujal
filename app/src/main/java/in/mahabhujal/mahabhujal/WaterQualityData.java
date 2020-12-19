package in.mahabhujal.mahabhujal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class WaterQualityData extends AppCompatActivity {
    Spinner spinner_water_method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_quality_data);



        Spinner spinner_water_method=findViewById(R.id.spinner_water_method);

        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(WaterQualityData.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.watermethod));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_water_method.setAdapter(myAdapter1);

    }
}