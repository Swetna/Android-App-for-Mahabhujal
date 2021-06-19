package in.mahabhujal.mahabhujal.waterQualityApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class WaterQualityClientApi {

    static final String BaseUrl = "http://dbitbeproject.herokuapp.com/";
   private static Retrofit retrofit;


    public static Retrofit getClientApi() {

/*
        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;

 */

        return new Retrofit.Builder()
                .baseUrl(WaterQualityClientApi.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
