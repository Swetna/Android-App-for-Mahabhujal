package in.mahabhujal.mahabhujal.rainApi;

import in.mahabhujal.mahabhujal.model.RainDataModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RainDataApi {

    @FormUrlEncoded
    @POST("raindatapost/")
    Call<RainDataModel> raindata(
            @Field("date") String date,
            @Field("stationId") String rainId,
            @Field("rain") String rain
    );


}
