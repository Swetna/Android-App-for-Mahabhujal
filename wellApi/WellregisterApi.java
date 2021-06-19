package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellRegisterModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WellregisterApi {

    @FormUrlEncoded
    @POST("wellregisterpost/")
    Call<WellRegisterModel> wellRegister(@Field("wellid") String wellid,
                                         @Field("image") String image,
                                         @Field("ownername") String ownername,
                                         @Field("location") String location,
                                         @Field("elevation") String elevation,
                                         @Field("depth") String depth,
                                         @Field("ownership")String ownership,
                                            @Field("purpose")String purpose);}
