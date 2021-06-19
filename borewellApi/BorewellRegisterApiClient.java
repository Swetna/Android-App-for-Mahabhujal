package in.mahabhujal.mahabhujal.borewellApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorewellRegisterApiClient {

    private static final String BaseUrl = "http://dbitbeproject.herokuapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {

        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }



}
