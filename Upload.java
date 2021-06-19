package in.mahabhujal.mahabhujal;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import in.mahabhujal.mahabhujal.borewellApi.BorewellSectApiClient;
import in.mahabhujal.mahabhujal.borewellApi.BorewellSectionApi;
import in.mahabhujal.mahabhujal.model.BorewellSectionModel;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Upload extends AppCompatActivity {

    TextView imgPath;
    private static final int PICK_IMAGE_REQUEST = 9544;
    ImageView image;
    Uri selectedImage;
    String part_image;
    EditText borewellid;

    ImageButton BSec_img;
    Button SubmitBoreSect;
    private Button selectImg;


    Bitmap bitmap;
    private  static final int IMAGE = 100;

    private static final int CAMERA_PIC_REQUEST = 1337;
    static int TAKE_PICTURE = 1;
    Uri photoPath;



    // Permissions for accessing the storage
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_section);
        //imgPath = (TextView)findViewById(R.id.imgPath);
        image = findViewById(R.id.bore_sect_imageView);
        borewellid = (EditText) findViewById(R.id.b_sect_code);
        BSec_img = (ImageButton) findViewById(R.id.bore_sect_icon_img);
        //SubmitBoreSect = (Button) findViewById(R.id.bore_sect_submit);
        selectImg = (Button) findViewById(R.id.select_img);

        BSec_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
            }

        });


        SubmitBoreSect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Upload();
                uploadImage();

            }
        });

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pick();

            }
        });



    }
    public void pick() {
        //verifyStoragePermissions(Upload.this);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Open Gallery"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST) {
            if (resultCode == RESULT_OK) {
                selectedImage = data.getData();                                                         // Get the image file URI
                String[] imageProjection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, imageProjection, null, null, null);
                if(cursor != null) {
                    cursor.moveToFirst();
                    int indexImage = cursor.getColumnIndex(imageProjection[0]);
                    part_image = cursor.getString(indexImage);
                    imgPath.setText(part_image);                                                        // Get the image file absolute path
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    image.setImageBitmap(bitmap);                                                       // Set the ImageView with the bitmap of the image
                }
            }
        }
    }


    public void uploadImage() {

        String Borewellid = borewellid.getText().toString();
        File imageFile = new File(part_image);                                                          // Create a file using the absolute path of the image
        RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"), imageFile);
        MultipartBody.Part partImage = MultipartBody.Part.createFormData("file", imageFile.getName(), reqBody);
        BorewellSectionApi api = BorewellSectApiClient.getInstance().getAPI();
        Call<BorewellSectionModel> upload = api.uploadImage(Borewellid, partImage);
        //Call<ResponseBody> upload = api.uploadImage(partImage);
        upload.enqueue(new Callback<BorewellSectionModel>() {
            @Override
            public void onResponse(Call<BorewellSectionModel> call, Response<BorewellSectionModel> response) {
                borewellid.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<BorewellSectionModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
