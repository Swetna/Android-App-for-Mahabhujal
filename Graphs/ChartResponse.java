package in.mahabhujal.mahabhujal.Graphs;

import com.google.gson.annotations.SerializedName;

public class ChartResponse {
    @SerializedName("rainfall")
    private Object rainResponse=null;

    @SerializedName("date")
    private Object dateResponse=null;

    public Object getRainResponse() {
        return rainResponse;
    }

    public Object getDateResponse() {
        return dateResponse;
    }
}
