package in.mahabhujal.mahabhujal.borewellApi;

import in.mahabhujal.mahabhujal.model.BorewellWaterLevelModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BorewellWaterLevelApi {
    @FormUrlEncoded
    @POST("borewellwaterlevelpost/")
    Call<BorewellWaterLevelModel> borewellwaterlevel(
            @Field("date") String date,
            @Field("preWaterLevel") String preWaterLevel,
            @Field("postWaterLevel") String postWaterLevel,
            @Field("potentWaterLevel") String potentWaterLevel,
            @Field("borewellid") String borewellid,
            @Field("available") String available
    );


}
