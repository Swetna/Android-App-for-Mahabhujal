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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import in.mahabhujal.mahabhujal.borewellApi.BorewellRegisterApi;
import in.mahabhujal.mahabhujal.borewellApi.BorewellRegisterApiClient;
import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperBorewell;
import in.mahabhujal.mahabhujal.model.BorewellRegisterModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BorewellFormActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    private EditText B_vol_name;
    private EditText B_owner_name;
    private EditText B_code;
    private EditText B_address;
    private EditText B_elevation;
    private EditText B_depth;
    private Button SubmitBorewell;
    private Button selectImg;
    ImageButton clickImg;
    ImageView imageView;
    RadioGroup purpose;
    RadioGroup ownership;
    RadioButton shared;
    RadioButton agri;
    RadioButton others;
    RadioButton radioButtonpublic;
    RadioButton radioButtonprivate;
    RadioButton radioButtondomestic;
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
        setContentView(R.layout.activity_borewell_form);
        openHelper = new DatabaseHelperBorewell(this);


        B_vol_name = (EditText) findViewById(R.id.vol_name);
        B_owner_name = (EditText) findViewById(R.id.b_owner);
        B_code = (EditText) findViewById(R.id.b_code);
        B_address = (EditText) findViewById(R.id.b_add);
        B_elevation = (EditText) findViewById(R.id.b_elevation);
        B_depth = (EditText) findViewById(R.id.b_depth);
        SubmitBorewell = (Button) findViewById(R.id.submit_form);
        purpose = (RadioGroup) findViewById(R.id.radioGroupBoretype);
        radioButtonpublic = (RadioButton) findViewById(R.id.b_public);
        radioButtonprivate = (RadioButton) findViewById(R.id.b_private);
        shared=(RadioButton) findViewById(R.id.b_shared);
        ownership=(RadioGroup) findViewById(R.id.radiogroupBoreOwnership);
        agri=(RadioButton) findViewById(R.id.b_agri);
        others=(RadioButton) findViewById(R.id.b_others);
        radioButtondomestic = (RadioButton) findViewById(R.id.b_dome);
        clickImg = (ImageButton) findViewById(R.id.register_bore_icon_img);
        imageView = (ImageView) findViewById(R.id.reg_bore_imageView);


        purpose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioButtonpublic.isChecked()) {
                    purpose_value = radioButtonpublic.getText().toString();
                } else if (radioButtonprivate.isChecked()) {
                    purpose_value = radioButtonprivate.getText().toString();
                }else if (shared.isChecked()) {
                    purpose_value = shared.getText().toString();
                }
                else {
                    Toast.makeText(BorewellFormActivity.this, "Select value", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ownership.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioButtondomestic.isChecked()) {
                    ownership_value = radioButtondomestic.getText().toString();
                } else if (agri.isChecked()) {
                    ownership_value = agri.getText().toString();
                }else if (others.isChecked()) {
                    ownership_value = others.getText().toString();
                }
                else {
                    Toast.makeText(BorewellFormActivity.this, "Select value", Toast.LENGTH_SHORT).show();
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

        SubmitBorewell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process();

                /*
                db=openHelper.getWritableDatabase();
                String BCode=B_code.getText().toString();
               String OwnerName=B_owner_name.getText().toString() ;
                String VolunteerName=B_vol_name.getText().toString();
                String Address=B_address.getText().toString();
                String BElevation=B_elevation.getText().toString();
                String BDepth=B_depth.getText().toString();
               // String BType=radioButton.getText().toString();

                //int SelectedRadioId=radioGroup.getCheckedRadioButtonId();
                //radioButton=(RadioButton) findViewById(R.id.SelectedRadioId);



                insertdata(BCode,OwnerName,VolunteerName,Address,BElevation,BDepth);
                Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_LONG).show();

               /* DatabaseHelper myDbHelper = new DatabaseHelper(BorewellFormActivity.this);
                 try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }
                Toast.makeText(BorewellFormActivity.this, "Successfully Imported", Toast.LENGTH_SHORT).show();
                c = myDbHelper.query("BorewellForm", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(BorewellFormActivity.this,
                                "_id: " + c.getString(0) + "\n" +
                                        "Owner: " + c.getString(1) + "\n" +
                                        "Volunteer: " + c.getString(2) + "\n" +
                                        "Address:  " + c.getString(3) + "\n" +
                                        "Elevation"+ c.getString(4) + "\n" +
                                        "Depth" + c.getString(5),

                                Toast.LENGTH_LONG).show();
                    } while (c.moveToNext());
                }*/
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


    private void process() {
        String image = convertToString();
        String Borewellid = B_code.getText().toString();
        String ownername=B_owner_name.getText().toString();
        String location=B_address.getText().toString();
        String elevation=B_elevation.getText().toString();
        String depth=B_depth.getText().toString();
        BorewellRegisterApi apiInterface = BorewellRegisterApiClient.getApiClient().create(BorewellRegisterApi.class);
        Call<BorewellRegisterModel> call = apiInterface.borewellRegister(Borewellid,image,ownername,location,elevation,depth,purpose_value,ownership_value);

        call.enqueue(new Callback<BorewellRegisterModel>() {
            @Override
            public void onResponse(Call<BorewellRegisterModel> call, Response<BorewellRegisterModel> response) {
                B_code.setText("");
                B_owner_name.setText("");
                B_address.setText("");
                B_elevation.setText("");
                B_depth.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<BorewellRegisterModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }
}







/*
    public void insertdata(String BCode,String OwnerName,String VolunteerName,String Address,String BElevation,String BDepth){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelperBorewell.COL_1,BCode);
        contentValues.put(DatabaseHelperBorewell.COL_2,OwnerName);
        contentValues.put(DatabaseHelperBorewell.COL_3,VolunteerName);
        contentValues.put(DatabaseHelperBorewell.COL_4,Address);
        contentValues.put(DatabaseHelperBorewell.COL_5,BElevation);
        contentValues.put(DatabaseHelperBorewell.COL_6,BDepth);
        //contentValues.put(DatabaseHelperRegBorewell.COL_7,BType);
        long id = db.insert(DatabaseHelperBorewell.TABLE_BOREWELL,null,contentValues);
    }
}



        /*B_data=(TextView) findViewById(R.id.bdata);
        Bpurpose=(TextView) findViewById(R.id.bpurpose);
        Bown=(TextView) findViewById(R.id.bownership);
        B_vol_name=(EditText) findViewById(R.id.vol_name);
        B_owner_name=(EditText) findViewById(R.id.b_owner);
        B_code=(EditText) findViewById(R.id.b_code);
        B_address=(EditText) findViewById(R.id.b_add);
        B_elevation=(EditText) findViewById(R.id.b_elevation);
        B_depth=(EditText) findViewById(R.id.b_depth);
        B_public=(RadioButton) findViewById(R.id.b_public);
        B_private=(RadioButton) findViewById(R.id.b_private);
        B_shared=(RadioButton) findViewById(R.id.b_shared);
        B_agri=(RadioButton) findViewById(R.id.b_agri);
        B_dome=(RadioButton) findViewById(R.id.b_dome);
        B_others=(RadioButton) findViewById(R.id.b_others);
        Submit=(Button) findViewById(R.id.submit);

         */



        //private void valid(String code,String own_name,String vol_name){
        //   if(code=="1234")
        //}


