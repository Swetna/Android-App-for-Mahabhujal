package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellStructModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WellStructApi {
    @FormUrlEncoded
    @POST("wellstructlevelpost/")
    Call<WellStructModel> wellstruct(
            @Field("wellid") String wellid,
            @Field("level1") String level1,
            @Field("level2") String level2,
            @Field("level3") String level3
    );


}
