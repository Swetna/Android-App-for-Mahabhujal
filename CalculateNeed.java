package in.mahabhujal.mahabhujal;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateNeed extends AppCompatActivity {
    Spinner spinner_requirements;

    SQLiteOpenHelper openHelperNeed;
    SQLiteDatabase db;

    private EditText NoOfPeople;
    private EditText DailyNeed;
    private TextView WaterNeeded;
    private EditText PeriodOfTime;
    private Button CalculateNeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_need);


            //--------------SPINER----------------//
        final Spinner spinner_requirement=findViewById(R.id.spinner_requirements);

        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(CalculateNeed.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.requirements));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_requirement.setAdapter(myAdapter1);


        //-----------------DATABASE-------------//

        //openHelperNeed = new DatabaseHelperRechargeStructure(this);

        NoOfPeople = (EditText) findViewById(R.id.no_of_people_number);
        DailyNeed = (EditText) findViewById(R.id.daily_need_number);
        WaterNeeded = (TextView) findViewById(R.id.water_need_calculated_number);
        //PeriodOfTime = (Spinner) findViewById(R.id.spinner_requirements);
        CalculateNeed = (Button) findViewById(R.id.but_calculate_need);



        CalculateNeed.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                double a = Double.parseDouble(NoOfPeople.getText().toString());
                //double a = new Double(NoOfPeople.getText().toString());
                double b = Double.parseDouble(DailyNeed.getText().toString());
                double need=(a*b);
                double weekly=((a*b)*7);
                double monthly=((a*b)*30);
                double yearly=((a*b)*365);


               //WaterNeeded.setText(""+need);

                String text = spinner_requirement.getSelectedItem().toString();
                //Toast.makeText(CalculateNeed.this,text, Toast.LENGTH_SHORT).show();
                if (text.equals("Daily")){
                    WaterNeeded.setText(""+need);
                }else if (text.equals("Weekly")){
                    WaterNeeded.setText(""+weekly);
                }else if (text.equals("Monthly")){
                    WaterNeeded.setText(""+monthly);
                }else if (text.equals("Yearly")){
                    WaterNeeded.setText(""+yearly);
                }


                /*
                else{
                    Toast.makeText(CalculateNeed.this, "Enter Appropriate value", Toast.LENGTH_SHORT).show();
                }

                 */





                /*
                db = openHelperNeed.getWritableDatabase();
                String No_Of_People = NoOfPeople.getText().toString();
                String Daily_Need = DailyNeed.getText().toString();
                String Water_Needed = WaterNeeded.getText().toString();


                insertdataneed(No_Of_People,Daily_Need,Water_Needed);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();

                 */



            }
        });

    }

    /*
    private void insertdataneed(String no_of_people, String daily_need, String water_needed) {

        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperRechargeStructure.COL_NEED_1,no_of_people);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_NEED_2,daily_need);
        contentValues1.put(DatabaseHelperRechargeStructure.COL_NEED_3,water_needed);

    }

     */
}