package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellWaterLevelModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WellWaterLevelApi {
    @FormUrlEncoded
    @POST("wellwaterlevelpost/")
    Call<WellWaterLevelModel> wellwaterlevel(
            @Field("date") String date,
            @Field("preWaterLevel") String preWaterLevel,
            @Field("postWaterLevel") String postWaterLevel,
            @Field("potentWaterLevel") String potentWaterLevel,
            @Field("wellid") String borewellid,
            @Field("available") String available,
            @Field("variation") String variation

    );

}
