package in.mahabhujal.mahabhujal.borewellApi;

import in.mahabhujal.mahabhujal.model.BorewellRegisterModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BorewellRegisterApi {

    @FormUrlEncoded
    @POST("borewellregisterpost/")
    Call<BorewellRegisterModel> borewellRegister(@Field("borewellid") String borewellid,
                                                 @Field("image") String image,
                                                 @Field("ownername") String ownername,
                                                 @Field("location") String location,
                                                 @Field("elevation") String elevation,
                                                 @Field("depth") String depth,
                                                 @Field("ownership")String ownership,
                                                @Field("purpose")String purpose);}




