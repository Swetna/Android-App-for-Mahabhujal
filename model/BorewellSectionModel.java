package in.mahabhujal.mahabhujal.model;

import com.google.gson.annotations.SerializedName;

public class BorewellSectionModel {

    @SerializedName("borewellid")
    private String borewellid;

    @SerializedName("image")
    private String image;


    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }

}
