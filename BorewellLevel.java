package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.borewellApi.BorewellWaterLevelApi;
import in.mahabhujal.mahabhujal.model.BorewellWaterLevelModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorewellLevel extends AppCompatActivity {

    SQLiteOpenHelper openHelperLevel;
    SQLiteDatabase db;

    private EditText borewellid;
    private EditText date;
    private EditText variation;
    private EditText preWaterLevel;
    private EditText postWaterLevel;
    private EditText potentWaterLevel;
    private RadioGroup available;
    private RadioButton yes;
    private RadioButton no;
    private Button Submit_waterlevel;
    public String available_water;
    String value;

    String url = "http://dbitbeproject.herokuapp.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_water_level);

        //openHelperLevel = new DatabaseHelperBorewell(this);

        borewellid = (EditText) findViewById(R.id.b_water_level_code);
        date = (EditText) findViewById(R.id.borewell_date);
        variation = (EditText) findViewById(R.id.b_variation);
        preWaterLevel = (EditText) findViewById(R.id.borewell_pre_monsoon);
        postWaterLevel = (EditText) findViewById(R.id.borewell_post_monsoon);
        potentWaterLevel = (EditText) findViewById(R.id.borewell_potent);
        available=(RadioGroup)findViewById(R.id.water_available_yesno);
        yes=(RadioButton)findViewById(R.id.bore_available_yes);
        no=(RadioButton)findViewById(R.id.bore_available_no);
        Submit_waterlevel = (Button) findViewById(R.id.submit_bore_waterlever);


        available.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (yes.isChecked()) {
                    value = yes.getText().toString();
                } else if (no.isChecked()) {
                    value = no.getText().toString();
                }else {
                    Toast.makeText(BorewellLevel.this, "Select value for availability", Toast.LENGTH_SHORT).show();
                }
            }

        });



        Submit_waterlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    process();


                /*
                db = openHelperLevel.getWritableDatabase();
                String BCode = B_code.getText().toString();
                String RecordDate = Record_date.getText().toString();
                String Variation = BVariation.getText().toString();
                String PreMonsoon = BPreMonsoon.getText().toString();
                String PostMonsoon = BPostMonsoon.getText().toString();
                String Potentionmeter = BPotentionmeter.getText().toString();

                insertdatalevel(BCode, RecordDate, Variation, PreMonsoon, PostMonsoon, Potentionmeter);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();


                 */
            }
        });
    }

    private void process() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BorewellWaterLevelApi api=retrofit.create(BorewellWaterLevelApi.class);

        Call<BorewellWaterLevelModel> call=api.borewellwaterlevel(borewellid.getText().toString(),date.getText().toString(),preWaterLevel.getText().toString(),postWaterLevel.getText().toString(),potentWaterLevel.getText().toString(),value);
        call.enqueue(new Callback<BorewellWaterLevelModel>() {
            @Override
            public void onResponse(Call<BorewellWaterLevelModel> call, Response<BorewellWaterLevelModel> response) {

                borewellid.setText("");
                date.setText("");
                preWaterLevel.setText("");
                postWaterLevel.setText("");
                potentWaterLevel.setText("");
                variation.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BorewellWaterLevelModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

}


    /*
    private void insertdatalevel(String BCode, String RecordDate, String Variation, String PreMonsoon, String PostMonsoon, String Potentionmeter) {
        ContentValues contentValues2=new ContentValues();
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_1,BCode);
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_2,RecordDate);
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_3,Variation);
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_4,PreMonsoon);
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_5,PostMonsoon);
        contentValues2.put(DatabaseHelperBorewell.COL_LEVEL_6,Potentionmeter);
        long id = db.insert(DatabaseHelperBorewell.TABLE_BWATERLEVEL,null,contentValues2);


    }

     */

