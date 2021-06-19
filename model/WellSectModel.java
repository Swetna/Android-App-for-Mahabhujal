package in.mahabhujal.mahabhujal.model;

import com.google.gson.annotations.SerializedName;

public class WellSectModel {

    @SerializedName("wellid")
    private String wellid;

    @SerializedName("image")
    private String image;


    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }


}
