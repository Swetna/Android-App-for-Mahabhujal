package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.model.WellPumpTestModel;
import in.mahabhujal.mahabhujal.wellApi.WellPumpTestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WellPumpTest extends AppCompatActivity {

    SQLiteOpenHelper openHelperPumpTest;
    SQLiteDatabase db;

    private EditText wellid;
    private EditText date;
    private EditText crop;
    private EditText area;
    private EditText WaterGiven;
    private EditText duration;
    private EditText method;
    private Spinner spin_seasons;
    private Button Submit_well_pumptest;

    String url = "http://dbitbeproject.herokuapp.com/";

    Spinner spinner_season, spinner_method;

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


        //------------SPINNER-------------//
        Spinner spinner__season = findViewById(R.id.spinner_seasons);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(WellPumpTest.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.seasons));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner__season.setAdapter(myAdapter1);



        //---------SQLite--------//

        //openHelperPumpTest = new DatabaseHelperWell(this);

        wellid = (EditText) findViewById(R.id.w_pumptest_code);
        date = (EditText) findViewById(R.id.wpumptest_date_recording);
        crop = (EditText) findViewById(R.id.crop_name);
        area = (EditText) findViewById(R.id.cultivated_area);
        WaterGiven = (EditText) findViewById(R.id.water_given_number);
        duration = (EditText) findViewById(R.id.duration_pump_number);
        method = (EditText) findViewById(R.id.method_used);
        spin_seasons=(Spinner)findViewById(R.id.spinner_seasons);
        Submit_well_pumptest = (Button) findViewById(R.id.pumptest_submit);




        Submit_well_pumptest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                process();
            }
        });

    }

    private void process() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String season = spin_seasons.getSelectedItem().toString();
        WellPumpTestApi api = retrofit.create(WellPumpTestApi.class);
        Call<WellPumpTestModel> call = api.wellpumptest(wellid.getText().toString(), date.getText().toString(), crop.getText().toString(), area.getText().toString(), WaterGiven.getText().toString(), duration.getText().toString(), method.getText().toString(),season);
        call.enqueue(new Callback<WellPumpTestModel>() {


            @Override
            public void onResponse(Call<WellPumpTestModel> call, Response<WellPumpTestModel> response) {

                wellid.setText("");
                date.setText("");
                crop.setText("");
                area.setText("");
                WaterGiven.setText("");
                duration.setText("");
                method.setText("");
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<WellPumpTestModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();


            }
        });
    }
}



/*
    db = openHelperPumpTest.getWritableDatabase();
    String WCode = W_code.getText().toString();
    String TestRecordDate =Test_Record_date.getText().toString();
    String Crop = Crops.getText().toString();
    String  Area_Cultivation = AreaCultivation.getText().toString();
    String No_water_given =WaterGiven.getText().toString();
    String Pump_Duration =Duration.getText().toString();
    String TestMethod =Method.getText().toString();

    insertdatapumptest(WCode,TestRecordDate,Crop,Area_Cultivation,No_water_given,Pump_Duration,TestMethod);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();


    private void insertdatapumptest(String wCode, String testRecordDate, String crop, String area_cultivation, String no_water_given, String pump_duration, String testMethod) {
        ContentValues contentValues2=new ContentValues();
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_1,wCode);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_2,testRecordDate);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_3,crop);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_4,area_cultivation);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_5,no_water_given);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_6,pump_duration);
        contentValues2.put(DatabaseHelperWell.COL_PUMPTEST_7,testMethod);
        long id = db.insert(DatabaseHelperWell.TABLE_WPUMPTEST,null,contentValues2);


    }


}

 */



/*
        Spinner spinner_method=findViewById(R.id.spinner_method);

        ArrayAdapter<String> myAdapter2= new ArrayAdapter<String>(WellPumpTest.this,
                android.R.layout.simple_list_item_2, getResources().getStringArray(R.array.water_method));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_method.setAdapter(myAdapter2);

 */