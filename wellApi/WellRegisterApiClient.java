package in.mahabhujal.mahabhujal.wellApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WellRegisterApiClient {
    private static final String BaseUrl = "http://dbitbeproject.herokuapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }


}
