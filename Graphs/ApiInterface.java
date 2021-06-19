package in.mahabhujal.mahabhujal.Graphs;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/raindataget/")
    Call<ChartResponse> getChartResponse();
}
