package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.borewellApi.BoreStructApi;
import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperBorewell;
import in.mahabhujal.mahabhujal.model.BoreStructModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorewellStruct extends AppCompatActivity {

    SQLiteOpenHelper openHelperStruct;
    SQLiteDatabase db;

    private EditText borewellid;
    private EditText level1;
    private EditText level2;
    private EditText level3;
    private Button SubmitBoreStruct;


    String url = "http://dbitbeproject.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_struct);

        openHelperStruct = new DatabaseHelperBorewell(this);

        borewellid = (EditText) findViewById(R.id.borewell_struct_code);
        level1 = (EditText) findViewById(R.id.b_water_struct_lev1);
        level2 = (EditText) findViewById(R.id.b_water_struct_lev2);
        level3 = (EditText) findViewById(R.id.b_water_struct_lev3);
        SubmitBoreStruct = (Button) findViewById(R.id.but_borewell_struct_submit);

        SubmitBoreStruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                process();

                /*
                db = openHelperStruct.getWritableDatabase();
                String BCode = B_code.getText().toString();
                String WaterLevel1 = Water_level1.getText().toString();
                String WaterLevel2 = Water_level2.getText().toString();
                String WaterLevel3 = Water_level3.getText().toString();

               // insertdatastruct(BCode, WaterLevel1, WaterLevel2, WaterLevel3);
                //Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();


                 */
            }
        });
    }

    private void process() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BoreStructApi api=retrofit.create(BoreStructApi.class);

        Call<BoreStructModel> call=api.borewellstruct(borewellid.getText().toString(),level1.getText().toString(),level2.getText().toString(),level3.getText().toString());
        call.enqueue(new Callback<BoreStructModel>(){
            @Override
            public void onResponse(Call<BoreStructModel> call, Response<BoreStructModel> response) {
                borewellid.setText("");
                level1.setText("");
                level2.setText("");
                level3.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<BoreStructModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }


    });

    }

    /*
    public void insertdatastruct(String BSCode,String WaterLevel1,String WaterLevel2,String WaterLevel3){
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperBorewell.COL_BS_1,BSCode);
        contentValues1.put(DatabaseHelperBorewell.COL_BS_2,WaterLevel1);
        contentValues1.put(DatabaseHelperBorewell.COL_BS_3,WaterLevel2);
        contentValues1.put(DatabaseHelperBorewell.COL_BS_4,WaterLevel3);
        long id = db.insert(DatabaseHelperBorewell.TABLE_BSTRUCT,null,contentValues1);
    }

     */
}