package in.mahabhujal.mahabhujal.borewellApi;

import in.mahabhujal.mahabhujal.model.BorewellSectionModel;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface BorewellSectionApi {

    @Multipart
    @POST("borewellsectionpost/")
    Call<BorewellSectionModel> uploadImage(@Part("borewellid") String borewellid,
                                           @Part MultipartBody.Part img);}
                                                //@Part("img") String img
// @Part MultipartBody.Part image);



