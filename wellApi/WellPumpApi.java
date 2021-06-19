package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellPumpModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WellPumpApi {

    @FormUrlEncoded
    @POST("wellpumpinghrspost/")
    Call<WellPumpModel> wellpump(
            @Field("date") String date,
            @Field("summer") String summer,
            @Field("monsoon") String monsoon,
            @Field("winter") String winter,
            @Field("wellid") String borewellid,
            @Field("discharge") String discharge
    );

}
