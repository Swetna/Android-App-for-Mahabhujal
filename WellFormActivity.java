package in.mahabhujal.mahabhujal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperWell;
import in.mahabhujal.mahabhujal.model.WellRegisterModel;
import in.mahabhujal.mahabhujal.wellApi.WellRegisterApiClient;
import in.mahabhujal.mahabhujal.wellApi.WellregisterApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WellFormActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    private TextView W_data;
    private EditText vol_name;
    private EditText W_owner_name;
    private EditText W_code;
    private EditText W_address;
    private EditText W_elevation;
    private EditText W_depth;
    private Button selectImg;
    ImageButton clickImg;
    ImageView imageView;

    private RadioButton W_public;
    private RadioButton W_private;
    private RadioButton W_shared;
    private RadioButton W_agri;
    private RadioButton W_dome;
    private RadioButton W_others;
    private Button SubmitWell;
    private RadioGroup Wpurpose;
    private RadioGroup Wown;
    String purpose_value;
    String ownership_value;



    Bitmap bitmap;
    private  static final int IMAGE = 100;

    private static final int CAMERA_PIC_REQUEST = 1337;
    static int TAKE_PICTURE = 1;
    Uri photoPath;

    //Cursor c = null;
    String url = "http://dbitbeproject.herokuapp.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_form);

        openHelper = new DatabaseHelperWell(this);


        vol_name = (EditText) findViewById(R.id.vol_name);
        W_owner_name = (EditText) findViewById(R.id.w_owner);
        W_code = (EditText) findViewById(R.id.w_code);
        W_address = (EditText) findViewById(R.id.w_address);
        W_elevation = (EditText) findViewById(R.id.w_elevation);
        W_depth = (EditText) findViewById(R.id.w_depth);
        SubmitWell = (Button) findViewById(R.id.submit_wellform);
        Wpurpose = (RadioGroup) findViewById(R.id.w_rad_purpose);
        W_public = (RadioButton) findViewById(R.id.w_public);
        W_private = (RadioButton) findViewById(R.id.w_private);
        W_shared=(RadioButton) findViewById(R.id.w_shared);
        Wown=(RadioGroup) findViewById(R.id.w_use);
        W_agri=(RadioButton) findViewById(R.id.w_agri);
        W_others=(RadioButton) findViewById(R.id.w_others);
        W_dome = (RadioButton) findViewById(R.id.w_dome);



        clickImg = (ImageButton) findViewById(R.id.register_well_icon_img);
        imageView = (ImageView) findViewById(R.id.reg_well_imageView);



        Wpurpose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (W_public.isChecked()) {
                    purpose_value = W_public.getText().toString();
                } else if (W_private.isChecked()) {
                    purpose_value = W_private.getText().toString();
                }else if (W_shared.isChecked()) {
                    purpose_value = W_shared.getText().toString();
                }
                else {
                    Toast.makeText(WellFormActivity.this, "Select value", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Wown.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (W_dome.isChecked()) {
                    ownership_value = W_dome.getText().toString();
                } else if (W_agri.isChecked()) {
                    ownership_value = W_agri.getText().toString();
                }else if (W_others.isChecked()) {
                    ownership_value = W_others.getText().toString();
                }
                else {
                    Toast.makeText(WellFormActivity.this, "Select value", Toast.LENGTH_SHORT).show();
                }
            }
        });


        clickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
            }

        });



        SubmitWell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                process();
            }
        });

    }

    private void process() {
        String image = convertToString();
        String wellid = W_code.getText().toString();
        String ownername=W_owner_name.getText().toString();
        String location=W_address.getText().toString();
        String elevation=W_elevation.getText().toString();
        String depth=W_depth.getText().toString();
        WellregisterApi apiInterface = WellRegisterApiClient.getApiClient().create(WellregisterApi.class);
        Call<WellRegisterModel> call = apiInterface.wellRegister(wellid,image,ownername,location,elevation,depth,purpose_value,ownership_value);

        call.enqueue(new Callback<WellRegisterModel>() {
                         @Override
                         public void onResponse(Call<WellRegisterModel> call, Response<WellRegisterModel> response) {
                             W_code.setText("");
                             W_owner_name.setText("");
                             W_address.setText("");
                             W_elevation.setText("");
                             W_depth.setText("");
                             Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                         }

                         @Override
                         public void onFailure(Call<WellRegisterModel> call, Throwable t) {
                             Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                         }
                     });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TAKE_PICTURE && resultCode == RESULT_OK && data!=null) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            imageView.setVisibility(View.VISIBLE);

        }
        else if(requestCode== IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String convertToString()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    }






/*
    db = openHelper.getWritableDatabase();
    String WCode = W_code.getText().toString();
    String WellOwnerName = W_owner_name.getText().toString();
    String VolunteerName = vol_name.getText().toString();
    String Address = W_address.getText().toString();
    String WElevation = W_elevation.getText().toString();
    String WDepth = W_depth.getText().toString();


    insertdata(WCode, WellOwnerName, VolunteerName, Address, WElevation, WDepth);
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_LONG).show();
    public void insertdata(String WCode, String WellOwnerName, String VolunteerName, String Address, String WElevation, String WDepth) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperWell.COL_1, WCode);
        contentValues.put(DatabaseHelperWell.COL_2, WellOwnerName);
        contentValues.put(DatabaseHelperWell.COL_3, VolunteerName);
        contentValues.put(DatabaseHelperWell.COL_4, Address);
        contentValues.put(DatabaseHelperWell.COL_5, WElevation);
        contentValues.put(DatabaseHelperWell.COL_6, WDepth);
        long id = db.insert(DatabaseHelperWell.TABLE_REGWELL, null, contentValues);
    }
}

    /*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

        }
    }

 */



