package in.mahabhujal.mahabhujal.rechargeApi;

import in.mahabhujal.mahabhujal.model.RechargeStructAddModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RechargeAddApi {

    @FormUrlEncoded
    @POST("rechargestructurepost/")
    Call<RechargeStructAddModel> rechargestruct(
            @Field("date") String date,
            @Field("type") String type,
            @Field("lat") String lat,
            @Field("longi") String longi,
            @Field("area") String area
    );


}
