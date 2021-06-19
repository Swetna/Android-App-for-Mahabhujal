package in.mahabhujal.mahabhujal.model;

import com.google.gson.annotations.SerializedName;

public class WellRegisterModel {
    @SerializedName("wellid")
    private String wellid;

    @SerializedName("ownername")
    private String ownername;

    @SerializedName("location")
    private String location;

    @SerializedName("elevation")
    private String elevation;

    @SerializedName("depth")
    private String depth;

    @SerializedName("image")
    private String image;

    @SerializedName("ownership")
    private String ownership;

    @SerializedName("purpose")
    private String purpose;


    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
