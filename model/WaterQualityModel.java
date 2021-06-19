package in.mahabhujal.mahabhujal.model;

import com.google.gson.annotations.SerializedName;

public class WaterQualityModel {

    @SerializedName("id")
    private String id;

    @SerializedName("file")
    private String file;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;


    @SerializedName("temp")
    private String temp;

    @SerializedName("pH")
    private String pH;

    @SerializedName("salinity")
    private String salinity;

    @SerializedName("tds")
    private String tds;

    @SerializedName("ec")
    private String ec;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }

}
