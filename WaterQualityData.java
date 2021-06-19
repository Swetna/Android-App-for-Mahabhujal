package in.mahabhujal.mahabhujal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import java.io.File;

import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperWaterQuality;
import in.mahabhujal.mahabhujal.model.WaterQualityModel;
import in.mahabhujal.mahabhujal.waterQualityApi.WaterQualityApi;
import in.mahabhujal.mahabhujal.waterQualityApi.WaterQualityClientApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaterQualityData extends AppCompatActivity {
    Spinner spinner_water_method;

    SQLiteOpenHelper openHelperQuality;
    SQLiteDatabase db;

    private EditText Code;
    private EditText Date;
    private EditText Time;
    private EditText Temperature;
    private EditText pH;
    private EditText Saline;
    private EditText TDS;
    private EditText EC;
    int borewellid;
    int wellid;
    TextView fileview;
    private Button SubmitWaterQuality;
    private Button ChooseFile;

    MultipartBody.Part multipartBody;
    String mediaPath, mediaPath1;
    String[] mediaColumns = {MediaStore.Video.Media._ID};
    ProgressDialog progressDialog;

    private static final int REQUEST_PICK_FILE = 1;
    Bitmap bitmap;
    private static final int FILE = 100;


    String url = "http://dbitbeproject.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_quality_data);


        //----------------SPINNER---------------------//
        final Spinner spinner_water_method = findViewById(R.id.spinner_water_method);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(WaterQualityData.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.watermethod));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_water_method.setAdapter(myAdapter1);


        spinner_water_method.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                if (spinner_water_method.getSelectedItem().toString().equals("Borewell")) {
                    Code.setHint("Borewellid");
                } else if (spinner_water_method.getSelectedItem().toString().equals("Well")) {
                    Code.setHint("WellCode");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        //-----------------DATABASE-------------------//

        openHelperQuality = new DatabaseHelperWaterQuality(this);

        Code = (EditText) findViewById(R.id.wbcode);
        Date = (EditText) findViewById(R.id.test_date);
        Time = (EditText) findViewById(R.id.test_time);
        Temperature = (EditText) findViewById(R.id.temperature);
        pH = (EditText) findViewById(R.id.ph);
        Saline = (EditText) findViewById(R.id.salinity);
        TDS = (EditText) findViewById(R.id.tds);
        EC = (EditText) findViewById(R.id.ec);
        fileview = (TextView) findViewById(R.id.file_view);
        ChooseFile = (Button) findViewById(R.id.choose_file);

        SubmitWaterQuality = (Button) findViewById(R.id.submit_quality);


        ChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();
            }
        });


        SubmitWaterQuality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });


    }

    private void upload() {



        final String file_name = fileview.toString();
        String Id = Code.getText().toString();
        final String DateOfTest= Date.getText().toString();
        String TimeOfTest =Time.getText().toString();
        String Temp =Temperature.getText().toString();
        String pHlevel =pH.getText().toString();
        String saline =Saline.getText().toString();
        final String tds =TDS.getText().toString();
        String ec =EC.getText().toString();



        File file = new File(file_name);

        // Parsing any Media type file
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());


        WaterQualityApi getResponse = WaterQualityClientApi.getClientApi().create(WaterQualityApi.class);
        Call<WaterQualityModel> call = getResponse.waterquality(filename,multipartBody,Id,DateOfTest,TimeOfTest,Temp,pHlevel,saline,tds,ec);
        call.enqueue(new Callback<WaterQualityModel>() {
            @Override
            public void onResponse(Call<WaterQualityModel> call, Response<WaterQualityModel> response) {
                Code.setText("");
                Date.setText("");
                Time.setText("");
                fileview.setText("");
                Temperature.setText("");
                pH.setText("");
                Saline.setText("");
                TDS.setText("");
                EC.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
    //progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<WaterQualityModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });





        /*


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


         */
        //WaterQualityApi apiInterface=retrofit.create(WaterQualityApi.class);


        //progressDialog.show();
/*
        WaterQualityApi apiInterface = WaterQualityClientApi.getClientApi().create(WaterQualityApi.class);
        Call<WaterQualityModel> call = apiInterface.waterquality(Id,file_name,DateOfTest,TimeOfTest,Temp,pHlevel,saline,tds,ec,multipartBodyfile);
        //Call<WaterQualityModel> call = apiInterface.waterquality(Id,file,DateOfTest,TimeOfTest,Temp,pHlevel,saline,tds,ec);

        call.enqueue(new Callback<WaterQualityModel>() {
            @Override
            public void onResponse(Call<WaterQualityModel> call, Response<WaterQualityModel> response) {
                Code.setText("");
                Date.setText("");
                Time.setText("");
                fileview.setText("");
                Temperature.setText("");
                pH.setText("");
                Saline.setText("");
                TDS.setText("");
                EC.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<WaterQualityModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

 */


    }


    private void selectFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 7);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 7:

                if (resultCode == RESULT_OK) {


                    Uri selectedFile = data.getData();
                    String[] filePathColumn = {MediaStore.Files.FileColumns.DATA};

                    Cursor cursor = getContentResolver().query(selectedFile, filePathColumn, null, null, null);
                    assert cursor != null;
                    cursor.moveToFirst();

                    String PathHolder = data.getData().getPath();
                    fileview.setText(PathHolder);
                    //int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    //mediaPath = cursor.getString(columnIndex);
                    //cursor.close();
                    // Toast.makeText(WaterQualityData.this, PathHolder , Toast.LENGTH_LONG).show();

                }
                break;

    }

}



    public long getFileId(Activity context, Uri fileUri) {
        Cursor cursor = context.managedQuery(fileUri, mediaColumns, null, null, null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
            return cursor.getInt(columnIndex);
        }
        return 0;
    }

    private String getRealPathFromURI(Uri data) {

        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),data,proj,null,null,null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;

    }
}




/*
            case 77:

                if ((requestCode == REQUEST_PICK_FILE) && (resultCode == RESULT_OK))//-1

        {

            File file = new File(getRealPathFromURI(data.getData()));

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), getRealPathFromURI(data.getData()));


            MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("file", file.getName(), requestFile);


            final String filename = fileview.toString();
            String Id = Code.getText().toString();
            final String DateOfTest = Date.getText().toString();
            String TimeOfTest = Time.getText().toString();
            String Temp = Temperature.getText().toString();
            String pHlevel = pH.getText().toString();
            String saline = Saline.getText().toString();
            final String tds = TDS.getText().toString();
            String ec = EC.getText().toString();


            WaterQualityApi apiInterface = WaterQualityClientApi.getClientApi().create(WaterQualityApi.class);
            Call<WaterQualityModel> call = apiInterface.waterquality(Id, filename, DateOfTest, TimeOfTest, Temp, pHlevel, saline, tds, ec, multipartBody);
            //Call<WaterQualityModel> call = apiInterface.waterquality(Id,file,DateOfTest,TimeOfTest,Temp,pHlevel,saline,tds,ec);

            call.enqueue(new Callback<WaterQualityModel>() {
                @Override
                public void onResponse(Call<WaterQualityModel> call, Response<WaterQualityModel> response) {
                    Code.setText("");
                    Date.setText("");
                    Time.setText("");
                    fileview.setText("");
                    Temperature.setText("");
                    pH.setText("");
                    Saline.setText("");
                    TDS.setText("");
                    EC.setText("");
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<WaterQualityModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                }
            });


        }break;

 */

/*

UploadReceiptService service = RetrofitClientInstance.getRetrofitInstance().create(UploadReceiptService.class);

String cookie = "cookiehere"
String stringValue = "stringValue"
file = new File(mFileName);

RequestBody requestFile =
        RequestBody.create(
                MediaType.parse("image/jpg"),
                file
        );

String items = "[1,2,4]";

MultipartBody.Part body =
        MultipartBody.Part.createFormData("files[0]", file.getName(), requestFile);

RequestBody items = RequestBody.create(MediaType.parse("application/json"), items);
RequestBody stringValue = RequestBody.create(MediaType.parse("text/plain"), stringValue);

Call<List<UploadResult>> call = service.uploadReceipt(cookie, body, items, stringValue);

call.enqueue(new Callback<List<UploadResult>>() {
    @Override
    public void onResponse(Call<List<UploadResult>> call, Response<List<UploadResult>> response) {
        if (response.code() == 204){
            returnToTwa(response.body());
        } else {

            Toast.makeText(ResultDetectReceiptActivity.this, "Upload Error: " + response.message(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Call<List<UploadResult>> call, Throwable t) {
        Toast.makeText(ResultDetectReceiptActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }
});


    db = openHelperQuality.getWritableDatabase();
    String WBCode =Code.getText().toString();
    String DateOfTest= Date.getText().toString();
    String TimeOfTest =Time.getText().toString();
    String Temp =Temperature.getText().toString();
    String pHlevel =pH.getText().toString();
    String saline =Saline.getText().toString();
    String tds =TDS.getText().toString();
    String ec =EC.getText().toString();

    insertdataquality(WBCode,DateOfTest,TimeOfTest,Temp,pHlevel,saline,tds,ec);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();



    private void insertdataquality(String wbCode, String dateOfTest, String timeOfTest, String temp, String pHlevel, String saline, String tds, String ec) {
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperWaterQuality.COL_1,wbCode);
        contentValues1.put(DatabaseHelperWaterQuality.COL_2,dateOfTest);
        contentValues1.put(DatabaseHelperWaterQuality.COL_3,timeOfTest);
        contentValues1.put(DatabaseHelperWaterQuality.COL_4,temp);
        contentValues1.put(DatabaseHelperWaterQuality.COL_5,pHlevel);
        contentValues1.put(DatabaseHelperWaterQuality.COL_6,saline);
        contentValues1.put(DatabaseHelperWaterQuality.COL_7,pHlevel);
        contentValues1.put(DatabaseHelperWaterQuality.COL_8,pHlevel);
        long id = db.insert(DatabaseHelperWaterQuality.TABLE_QUALITY,null,contentValues1);





    }

 */
