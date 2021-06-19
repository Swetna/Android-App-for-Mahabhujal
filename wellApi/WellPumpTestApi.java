package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellPumpTestModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WellPumpTestApi {

    @FormUrlEncoded
    @POST("wellpumptestpost/")
    Call<WellPumpTestModel> wellpumptest(
            @Field("date") String date,
            @Field("crop") String crop,
            @Field("area") String area,
            @Field("duration") String duration,
            @Field("no_of_times") String no_of_times,
            @Field("wellid") String wellid,
            @Field("method") String method,
            @Field("season") String season
    );
}
