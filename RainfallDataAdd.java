package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperRainData;
import in.mahabhujal.mahabhujal.model.RainDataModel;
import in.mahabhujal.mahabhujal.rainApi.RainDataApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RainfallDataAdd extends AppCompatActivity {
    SQLiteOpenHelper openHelperRainfall;
    SQLiteDatabase db;

    private EditText SID;
    private EditText RainfallAmount;
    private EditText DateOfRecording;
    private Button SubmitRainfall;

    String url = "http://dbitbeproject.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainfall_data_add);

        openHelperRainfall = new DatabaseHelperRainData(this);

        SID = (EditText) findViewById(R.id.station_id);
        RainfallAmount = (EditText) findViewById(R.id.rainfall);
        DateOfRecording = (EditText) findViewById(R.id.rain_date);
        SubmitRainfall = (Button) findViewById(R.id.submit_rainfall_data);

        SubmitRainfall.setOnClickListener(new View.OnClickListener() {
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

        RainDataApi api=retrofit.create(RainDataApi.class);

        Call<RainDataModel> call=api.raindata(SID.getText().toString(),RainfallAmount.getText().toString(),DateOfRecording.getText().toString());
        call.enqueue(new Callback<RainDataModel>() {
            @Override
            public void onResponse(Call<RainDataModel> call, Response<RainDataModel> response) {

                SID.setText("");
                DateOfRecording.setText("");
                RainfallAmount.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RainDataModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }
}




/*
    db = openHelperRainfall.getWritableDatabase();
    String StationID =SID.getText().toString();
    String AmountRain = RainfallAmount.getText().toString();
    String DateofRecording =DateOfRecording.getText().toString();

    insertdatarainfall(StationID,AmountRain,DateofRecording);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();


    private void insertdatarainfall(String stationID, String amountRain, String dateofRecording) {
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperRainData.COL_DATA_1,stationID);
        contentValues1.put(DatabaseHelperRainData.COL_DATA_2,amountRain);
        contentValues1.put(DatabaseHelperRainData.COL_DATA_3,dateofRecording);
        long id = db.insert(DatabaseHelperRainData.TABLE_RAINFALL,null,contentValues1);


    }

 */
