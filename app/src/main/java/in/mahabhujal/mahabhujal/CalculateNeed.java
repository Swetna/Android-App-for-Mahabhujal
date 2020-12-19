package in.mahabhujal.mahabhujal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateNeed extends AppCompatActivity {
    Spinner spinner_requirements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_need);



        Spinner spinner_requirements=findViewById(R.id.spinner_requirements);

        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(CalculateNeed.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.requirements));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_requirements.setAdapter(myAdapter1);
    }
}