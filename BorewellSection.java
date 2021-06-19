package in.mahabhujal.mahabhujal;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import in.mahabhujal.mahabhujal.borewellApi.BorewellSectApiClient;
import in.mahabhujal.mahabhujal.borewellApi.BorewellSectionApi;
import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHandlerBorewell;
import in.mahabhujal.mahabhujal.databaseHelpers.DatabaseHelperBorewell;
import in.mahabhujal.mahabhujal.model.BorewellSectionModel;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import android.support.design.widget.Snackbar;
//import android.support.v7.widget.Toolbar;


public class BorewellSection extends AppCompatActivity {
    SQLiteOpenHelper openHelperSection;
    //SQLiteDatabase db;
    DatabaseHandlerBorewell db;

    EditText borewellid;
    ImageButton BSec_img;
    Button SubmitBoreSect;
    ImageView imageView;
    private Button selectImg;

    Bitmap bitmap;
    private static final int IMAGE = 100;

    private static final int CAMERA_PIC_REQUEST = 1337;
    static int TAKE_PICTURE = 1;
    Uri photoPath;
    TextView imgPath;
    private static final int PICK_IMAGE_REQUEST = 9544;
    ImageView image;
    Uri selectedImage;
    String part_image;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    public static final String URL = "http://dbitbeproject.herokuapp.com/";

    public static final String DATA_URL = "/storage/emulated/0/DCIM/Camera/IMG_20210520_182510.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_section);

        openHelperSection = new DatabaseHelperBorewell(this);
        db=new DatabaseHandlerBorewell(this);


        borewellid = (EditText) findViewById(R.id.b_sect_code);
        BSec_img = (ImageButton) findViewById(R.id.bore_sect_icon_img);
        //SubmitBoreSect = (Button) findViewById(R.id.bore_sect_submit);
        selectImg = (Button) findViewById(R.id.select_img);
        imageView = (ImageView) findViewById(R.id.bore_sect_imageView);



        EnableRuntimePermission();


        BSec_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
            }

        });


      /*  SubmitBoreSect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Upload();
                //uploadImage();

            }
        });

       */

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();

            }
        });

    }


    public String getPath(Uri uri){
       if (uri==null)return null;
       String[] projection={MediaStore.Images.Media.DATA};
        Cursor cursor=managedQuery(uri,projection,null,null,null);
        if (cursor!=null){
            int column_index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return  cursor.getString(column_index);
        }
        return uri.getPath();
    }




    private void selectImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE);
        //startActivityForResult(Intent.createChooser(intent, "Open Gallery"), PICK_IMAGE_REQUEST);

    }

    private String convertToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }


    private void EnableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(BorewellSection.this,
                Manifest.permission.CAMERA)) {

            Toast.makeText(BorewellSection.this, "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            //ActivityCompat.requestPermissions(BorewellSection.this, new String[]{
            //      Manifest.permission.CAMERA},RequestPermissionCode);

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK && data!= null) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            imageView.setVisibility(View.VISIBLE);


            String x=(DATA_URL);
            Integer borecode=Integer.parseInt(borewellid.getText().toString());
            if (db.insertdata(x,borecode)){
                Toast.makeText(getApplicationContext(), "Data Successfully Added", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }


        }




        if (requestCode == IMAGE && resultCode == RESULT_OK && data != null) {

            Uri path = data.getData();
            String x=getPath(path);
            Integer borecode=Integer.parseInt(borewellid.getText().toString());
            if (db.insertdata(x,borecode)){
                Toast.makeText(getApplicationContext(), "Data Successfully Added", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }




        private void uploadImage() {
            // String image = convertToString();
       /*
        String Borewellid = borewellid.getText().toString();
            File imageFile = new File(part_image);                                                          // Create a file using the absolute path of the image
            RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"), imageFile);
            MultipartBody.Part partImage = MultipartBody.Part.createFormData("file", imageFile.getName(), reqBody);
            BorewellSectionApi api = BorewellSectApiClient.getInstance().getAPI();
            Call<BorewellSectionModel> call = api.uploadImage(Borewellid, partImage);

        */

            File file = new File("/storage/emulated/0/DCIM/Camera/IMG_20210520_182510.jpg");
            RequestBody requestFile =
                    RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part is used to send also the actual file name
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("image", file.getName(), requestFile);

            String image = convertToString();
            String Borewellid = borewellid.getText().toString();
            BorewellSectionApi api = BorewellSectApiClient.getInstance().getAPI();
            Call<BorewellSectionModel> call = api.uploadImage(Borewellid, body);
            // BorewellSectionApi apiInterface = BorewellSectApiClient.getApiClient().create(BorewellSectionApi.class);
            // Call<BorewellSectionModel> call = apiInterface.uploadImage(Borewellid,body);


            call.enqueue(new Callback<BorewellSectionModel>() {
                @Override
                public void onResponse(Call<BorewellSectionModel> call, Response<BorewellSectionModel> response) {
                    borewellid.setText("");
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<BorewellSectionModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                }
            });

        }


    }



/*
        SubmitBoreSect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelperSection.getWritableDatabase();
                String BSectCode=BSect_code.getText().toString();
                //String BSecImg=BSec_img.getImageAlpha().toString();

                insertdatasection(BSectCode);
                Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_LONG).show();

            }


        });

 */




    /*
    public void insertdatasection(String BSecCode){
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperBorewell.COL_SECT_1,BSecCode);
        //contentValues1.put(DatabaseHelperRegBorewell.COL_BSect_2,BSectImg);
        long id = db.insert(DatabaseHelperBorewell.TABLE_BSECTION,null,contentValues1);
    }

     */

     /*
        private void EnableRuntimePermission()
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(BorewellSection.this,
                    Manifest.permission.CAMERA)) {

                Toast.makeText(BorewellSection.this, "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

            } else {

                //ActivityCompat.requestPermissions(BorewellSection.this, new String[]{
                //      Manifest.permission.CAMERA},RequestPermissionCode);

            }

        }

        @Override
        public void onRequestPermissionsResult ( int RC, String per[],int[] PResult){

            switch (RC) {

                case 200:

                    if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                        Toast.makeText(BorewellSection.this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(BorewellSection.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                    }
                    break;
            }



        }

         public void insertdatasection(String BSecCode, Blob image){
        ContentValues contentValues1=new ContentValues();
        contentValues1.put(DatabaseHelperBorewell.COL_SECT_1,BSecCode);
        contentValues1.put(DatabaseHelperBorewell.COL_SECT_2, String.valueOf(image));
        long id = db.insert(DatabaseHelperBorewell.TABLE_BSECTION,null,contentValues1);
    }


 File file = new File("/storage/emulated/0/DCIM/Camera/IMG_20210520_182510.jpg");





 <Button
        android:id="@+id/bore_sect_submit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/submit"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.458"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.929" />

         */


