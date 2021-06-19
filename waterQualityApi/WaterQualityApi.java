package in.mahabhujal.mahabhujal.waterQualityApi;

import in.mahabhujal.mahabhujal.model.WaterQualityModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface WaterQualityApi {
    @Multipart
    @POST("waterquality/")

    Call<WaterQualityModel> waterquality(@Part("file") RequestBody filename,
                                         @Part MultipartBody.Part file,
                                         @Query("id") String id,
                                         @Query("date") String date,
                                         @Query("time") String time,
                                         @Query("temp") String temp,
                                         @Query("pH") String pH,
                                         @Query("salinity") String salinity,
                                         @Query("TDS") String tds,
                                         @Query("ec") String ec);
}


/*
 Call<WaterQualityModel>waterquality(@Query("id") String id,
                                         @Query("date") String date,
                                         @Query("time") String time,
                                         @Query("temp") String temp,
                                         @Query("pH") String pH,
                                         @Query("salinity") String salinity,
                                         @Query("TDS") String tds,
                                         @Query("ec") String ec,
                                         @Part("file") RequestBody filename,
                                        @Part MultipartBody.Part file);
 */