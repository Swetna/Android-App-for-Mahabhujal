

package in.mahabhujal.mahabhujal.registration;

import in.mahabhujal.mahabhujal.model.Users;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface PostApi {

    @FormUrlEncoded
   @POST("userpost/")
    Call<Users> registerUsers(
            @Field("username") String username,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("password") String password
   );


}
    /*
    String root = "http://192.168.0.105:8000/";
//    String root = "http://127.0.0.1:8000/";


    String base_local = root + "api/v1/";
    String BASE_URL = base_local + "account/";
    String POST_URL = base_local + "post/";
    String API_URL = root + "api/v1/";



//    @POST("api-token-auth/")
//    Call<User> login(@Body Login login);

    @POST("register/")
    Call<Users> registrationUser(@Body Users userModel);


//    @GET("post/list/")
//    Call<List<PostModel>> getListPost();
//
//    @GET("post/{id}/")
//    Call<PostModel> getPost(@Path(value = "id", encoded = true) String id);
//
//    @POST("add/")
//    Call<PostModel> addPost(@Header("Authorization")  String authToken, @Body PostModel postModel);
//
//    @GET("profile/list/")
//    Call<List<PostModel>> getProfileList(@Header("Authorization")  String authToken);
//
//
//    @PUT("profile/edit/{id}/")
//    Call<PostModel> updatePost(@Header("Authorization")  String authToken, @Body PostModel postModelUpdate, @Path(value = "id", encoded = true) String id);
//
//
//    @DELETE("profile/delete/{id}/")
//    Call<List<PostModel>> deletePost(@Header("Authorization")  String authToken, @Path(value = "id", encoded = true) String id);
//
//
//    @GET("category/list/")
//    Call<List<CategoryModel>> getAllCategory();
//
//    @GET("list/{id}/")
//    Call<List<CategoryModel>> getCategoryById(@Path(value = "id", encoded = true) Integer id);


     */





