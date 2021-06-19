package in.mahabhujal.mahabhujal.borewellApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorewellSectApiClient {

    private static final String BaseUrl = "http://dbitbeproject.herokuapp.com/";
    private static Retrofit retrofit;
    private static BorewellSectApiClient mInstance;


    /*public static Retrofit getApiClient() {

        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

     */

    private BorewellSectApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized BorewellSectApiClient getInstance() {
        if (mInstance == null) {
            mInstance = new BorewellSectApiClient();
        }
        return mInstance;
    }

    public BorewellSectionApi getAPI() {
        return retrofit.create(BorewellSectionApi.class);
    }
}

