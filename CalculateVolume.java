package in.mahabhujal.mahabhujal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateVolume extends AppCompatActivity {

    SQLiteOpenHelper openHelperVol;
    SQLiteDatabase db;

    private EditText CatchmentArea;
    private EditText CatchmentUnit;
    private EditText RainfallHeight;
    private EditText RainfallHeightUnit;
    private TextView WaterVolume;
    private TextView WaterVolumeUnit;
    private Button CalculateVolume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_volume);

        //openHelperVol = new DatabaseHelperRechargeStructure(this);

        CatchmentArea = (EditText) findViewById(R.id.catchment);
        CatchmentUnit = (EditText) findViewById(R.id.unit_catch);
        RainfallHeight = (EditText) findViewById(R.id.rain_height);
        RainfallHeightUnit = (EditText) findViewById(R.id.unit_rain_height);
        WaterVolume = (TextView) findViewById(R.id.water_volume);
        WaterVolumeUnit = (TextView) findViewById(R.id.unit_water_vol);
        CalculateVolume = (Button) findViewById(R.id.but_calculate_volume);

        CalculateVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(CatchmentArea.getText().toString());
                double b = Double.parseDouble(RainfallHeight.getText().toString());
                String a_unit= (CatchmentUnit.getText().toString());
                String b_unit= (RainfallHeightUnit.getText().toString());
                double volume=(a*b);


                WaterVolume.setText(""+volume);
                WaterVolume.setTextColor(Color.DKGRAY);
                WaterVolumeUnit.setText(a_unit+"/"+b_unit);
                WaterVolumeUnit.setTextColor(Color.DKGRAY);
                /*
                db = openHelperVol.getWritableDatabase();
                String Catchment_Area = CatchmentArea.getText().toString();
                String Catchment_Unit = CatchmentUnit.getText().toString();
                String Rainfall_Height = RainfallHeight.getText().toString();
                String RainfallHeight_Unit = RainfallHeightUnit.getText().toString();
                String Water_Volume = WaterVolume.getText().toString();
                String WaterVolume_Unit = WaterVolumeUnit.getText().toString();

                insertdatavolume(Catchment_Area,Catchment_Unit,Rainfall_Height,RainfallHeight_Unit,Water_Volume,WaterVolume_Unit);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();

                 */


            }
        });


    }


    /*
    private void insertdatavolume(String catchment_area, String catchment_unit, String rainfall_height, String rainfallHeight_unit, String water_volume, String waterVolume_unit) {

        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_1,catchment_area);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_2,catchment_unit);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_3,rainfall_height);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_4,rainfallHeight_unit);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_5,water_volume);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_VOL_6,waterVolume_unit);
        long id = db.insert(DatabaseHelperRechargeStructure.TABLE_VOLUME,null,contentValues1);



    }

     */
}