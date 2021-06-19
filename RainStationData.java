package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.model.RainStationModel;
import in.mahabhujal.mahabhujal.rainApi.RainStationApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RainStationData extends AppCompatActivity {

    SQLiteOpenHelper openHelperRainStation;
    SQLiteDatabase db;

    private EditText SID;
    private EditText Volunteer;
    private EditText Lat;
    private EditText Long;
    private EditText Address;
    private EditText Date;
    private Button SubmitRainstationData;

    String url = "http://dbitbeproject.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_station_data);

        //openHelperRainStation = new DatabaseHelperRainData(this);

        SID = (EditText) findViewById(R.id.station_id);
        Volunteer = (EditText) findViewById(R.id.vol_name);
        Lat = (EditText) findViewById(R.id.lat);
        Long = (EditText) findViewById(R.id.longitude);
        Address = (EditText) findViewById(R.id.rainstation_address);
        Date = (EditText) findViewById(R.id.rainstation_date);
        SubmitRainstationData = (Button) findViewById(R.id.submit_rainstation);

        SubmitRainstationData.setOnClickListener(new View.OnClickListener() {
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

        RainStationApi api=retrofit.create(RainStationApi.class);

        Call<RainStationModel> call=api.rainstationdata(SID.getText().toString(),Lat.getText().toString(),Long.getText().toString(),Address.getText().toString(),Date.getText().toString(),Volunteer.getText().toString());
        call.enqueue(new Callback<RainStationModel>() {
            @Override
            public void onResponse(Call<RainStationModel> call, Response<RainStationModel> response) {
                SID.setText("");
                Lat.setText("");
                Long.setText("");
               Address.setText("");
                Date.setText("");
                Volunteer.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<RainStationModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}


/*
    db = openHelperRainStation.getWritableDatabase();
    String StationID =SID.getText().toString();
    String Volunteer_name = Volunteer.getText().toString();
    String Latitude =Lat.getText().toString();
    String Longitude =Long.getText().toString();
    String StationAddress =Address.getText().toString();
    String DateofRecording =Date.getText().toString();

    insertdatarainstation(StationID,Volunteer_name,Latitude,Longitude,StationAddress,DateofRecording);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();



    private void insertdatarainstation(String stationID, String volunteer_name, String latitude, String longitude, String stationAddress, String dateofRecording) {
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperRainData.COL_STATION_1,stationID);
        contentValues1.put(DatabaseHelperRainData.COL_STATION_2,volunteer_name);
        contentValues1.put(DatabaseHelperRainData.COL_STATION_3,latitude);
        contentValues1.put(DatabaseHelperRainData.COL_STATION_4,longitude);
        contentValues1.put(DatabaseHelperRainData.COL_STATION_5,stationAddress);
        contentValues1.put(DatabaseHelperRainData.COL_STATION_6,dateofRecording);
        long id = db.insert(DatabaseHelperRainData.TABLE_RAINSTATION,null,contentValues1);



    }

 */
