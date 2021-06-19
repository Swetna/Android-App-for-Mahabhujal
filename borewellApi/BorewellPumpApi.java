package in.mahabhujal.mahabhujal.borewellApi;

import in.mahabhujal.mahabhujal.model.BorewellPumpModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BorewellPumpApi {

    @FormUrlEncoded
    @POST("borewellpumpingpost/")
    Call<BorewellPumpModel> borewellpump(
            @Field("date") String date,
            @Field("summer") String summer,
            @Field("monsoon") String monsoon,
            @Field("winter") String winter,
            @Field("borewellid") String borewellid,
            @Field("discharge") String discharge
    );

}

