package in.mahabhujal.mahabhujal.wellApi;

import in.mahabhujal.mahabhujal.model.WellSectModel;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface WellSectApi{
    @Multipart
    @POST("wellsectionpost/")
    Call<WellSectModel> uploadImage(@Part("wellid") String wellid,
                                    @Part MultipartBody.Part image);}

                                    // @Part("img") String img


