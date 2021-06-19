package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.mahabhujal.mahabhujal.model.RechargeStructAddModel;
import in.mahabhujal.mahabhujal.rechargeApi.RechargeAddApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddRechargeStruct extends AppCompatActivity {

    SQLiteOpenHelper openHelperAddStruct;
    SQLiteDatabase db;

    private EditText StructType;
    private EditText Lat;
    private EditText Long;
    private EditText CreationDate;
    private EditText Area;
    private Button SubmitAddRecStruct;


    String url = "http://dbitbeproject.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_struct_fragment);

        //openHelperAddStruct = new DatabaseHelperRechargeStructure(this);

        StructType = (EditText) findViewById(R.id.type_struct);
        Lat = (EditText) findViewById(R.id.struct_lat);
        Long = (EditText) findViewById(R.id.struct_lon);
        CreationDate = (EditText) findViewById(R.id.struct_date_creation);
        Area = (EditText) findViewById(R.id.recharge_area);
        SubmitAddRecStruct = (Button) findViewById(R.id.submit_add_recharge_struct);

        SubmitAddRecStruct.setOnClickListener(new View.OnClickListener() {
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

        RechargeAddApi api=retrofit.create(RechargeAddApi.class);

        Call<RechargeStructAddModel> call=api.rechargestruct(StructType.getText().toString(),CreationDate.getText().toString(),Lat.getText().toString(),Long.getText().toString(),Area.getText().toString());
        call.enqueue(new Callback<RechargeStructAddModel>() {
            @Override
            public void onResponse(Call<RechargeStructAddModel> call, Response<RechargeStructAddModel> response) {

                StructType.setText("");
                CreationDate.setText("");
                Lat.setText("");
                Long.setText("");
                Area.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<RechargeStructAddModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }

}

/*
    db = openHelperAddStruct.getWritableDatabase();

    String Type = StructType.getText().toString();
    String StructLat = Lat.getText().toString();
    String StructLong = Long.getText().toString();
    String Creation_Date = CreationDate.getText().toString();
    String StructArea = Area.getText().toString();

    insertdatarecstruct(Type, StructLat,StructLong,Creation_Date,StructArea);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();


    private void insertdatarecstruct(String type, String structLat, String structLong, String creation_date, String structArea) {

        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperRechargeStructure.COL_ADD_1,type);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_ADD_2,structLat);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_ADD_3,structLong);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_ADD_4,creation_date);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_ADD_5,structArea);
        long id = db.insert(DatabaseHelperRechargeStructure.TABLE_ADD_RECHARGE_STRUCTURE,null,contentValues1);


    }

 */
