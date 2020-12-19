package in.mahabhujal.mahabhujal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class WellPumpTest extends AppCompatActivity {

    Spinner spinner_season,spinner_method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_pump_test);

/*
        spinner_season=findViewById(R.id.spinner_season);
        spinner_method=findViewById(R.id.spinner_method);


        String[] value={"Summer","Monsoon","Winter"};
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(this,
        R.layout.activity_well_pump_test,arrayList);
        spinner_season.setAdapter(myAdapter1);

        String[] value2={"Drip","Sprinkle","Flood"};
        ArrayList<String> arrayList2=new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> myAdapter2= new ArrayAdapter<String>(this,
                R.layout.activity_well_pump_test,arrayList2);
        spinner_method.setAdapter(myAdapter2);

 */



        Spinner spinner_season=findViewById(R.id.spinner_season);

        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(WellPumpTest.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.seasons));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_season.setAdapter(myAdapter1);


/*
        Spinner spinner_method=findViewById(R.id.spinner_method);

        ArrayAdapter<String> myAdapter2= new ArrayAdapter<String>(WellPumpTest.this,
                android.R.layout.simple_list_item_2, getResources().getStringArray(R.array.water_method));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_method.setAdapter(myAdapter2);

 */






    }




}