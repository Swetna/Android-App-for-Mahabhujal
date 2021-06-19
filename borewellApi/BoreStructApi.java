package in.mahabhujal.mahabhujal.borewellApi;

import in.mahabhujal.mahabhujal.model.BoreStructModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BoreStructApi {

    @FormUrlEncoded
    @POST("borewellstructlevelpost/")
    Call<BoreStructModel> borewellstruct(
            @Field("borewellid") String borewellid,
            @Field("level1") String level1,
            @Field("level2") String level2,
            @Field("level3") String level3
    );

}
