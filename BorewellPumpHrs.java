package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.borewellApi.BorewellPumpApi;
import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperBorewell;
import in.mahabhujal.mahabhujal.model.BorewellPumpModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorewellPumpHrs extends AppCompatActivity {

    SQLiteOpenHelper openHelperPump;
    SQLiteDatabase db;

    private EditText borewellid;
    private EditText date;
    private EditText summer;
    private EditText monsoon;
    private EditText winter;
    private EditText discharge;
    private Button Submit_borepumphrs;


    String url = "http://dbitbeproject.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_pump_hrs);

        openHelperPump = new DatabaseHelperBorewell(this);

        borewellid = (EditText) findViewById(R.id.b_pump_code);
        date = (EditText) findViewById(R.id.pumpdate_recording);
        summer = (EditText) findViewById(R.id.pump_b_summer);
        monsoon = (EditText) findViewById(R.id.pump_b_monsoon);
        winter = (EditText) findViewById(R.id.pump_b_winter);
        discharge = (EditText) findViewById(R.id.borewell_discharge);
        Submit_borepumphrs = (Button) findViewById(R.id.bore_pumphrs_submit);

        Submit_borepumphrs.setOnClickListener(new View.OnClickListener() {
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

        BorewellPumpApi api=retrofit.create(BorewellPumpApi.class);

        Call<BorewellPumpModel> call=api.borewellpump(borewellid.getText().toString(),date.getText().toString(),summer.getText().toString(),monsoon.getText().toString(),winter.getText().toString(),discharge.getText().toString());
        call.enqueue(new Callback<BorewellPumpModel>() {
            @Override
            public void onResponse(Call<BorewellPumpModel> call, Response<BorewellPumpModel> response) {
                borewellid.setText("");
                date.setText("");
                summer.setText("");
                winter.setText("");
                monsoon.setText("");
                discharge.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BorewellPumpModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }

}





 /*
                db = openHelperPump.getWritableDatabase();
                String BCode = B_code.getText().toString();
                String PumpRecordDate =Pump_Record_date.getText().toString();
                String Variation_Summer = VariationSummer.getText().toString();
                String  Variation_Monsoon = VariationMonsoon.getText().toString();
                String Variation_Winter = VariationWinter.getText().toString();
                String Pump_DischargeRate =DischargeRate.getText().toString();

                insertdatapump(BCode,PumpRecordDate,Variation_Summer,Variation_Monsoon,Variation_Winter,Pump_DischargeRate);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();

                 */

/*
    private void insertdatapump(String bCode, String pumpRecordDate, String variation_summer, String variation_monsoon, String variation_winter, String pump_dischargeRate) {
        ContentValues contentValues2=new ContentValues();
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_1,bCode);
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_2,pumpRecordDate);
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_3,variation_summer);
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_4,variation_monsoon);
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_5,variation_winter);
        contentValues2.put(DatabaseHelperBorewell.COL_PUMP_6,pump_dischargeRate);
        long id = db.insert(DatabaseHelperBorewell.TABLE_BPUMP,null,contentValues2);

    }

 */




