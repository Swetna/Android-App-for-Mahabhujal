package in.mahabhujal.mahabhujal.rainApi;

import in.mahabhujal.mahabhujal.model.RainStationModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RainStationApi {
    @FormUrlEncoded
    @POST("rainstationpost/")
    Call<RainStationModel> rainstationdata(
            @Field("date") String date,
            @Field("stationId") String rainId,
            @Field("volname") String volunteername,
            @Field("lat") String lat,
            @Field("longi") String longi,
            @Field("address") String address

    );



}
