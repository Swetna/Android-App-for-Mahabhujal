package in.mahabhujal.mahabhujal.loginApi;

import in.mahabhujal.mahabhujal.model.LoginModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface LoginApi {


    //@GET("userget/{email}/{password}")
    //Call<LoginModel> login(@Path("email") String email, @Path("password") String password);


    @GET("userget/{email}/{password}")
    Call<LoginModel> login(@Query("email") String email, @Query("password") String password);


    // @POST("userget")
   // Call<LoginModel> login(@Field("email") String email, @Field("password") String password);




}
