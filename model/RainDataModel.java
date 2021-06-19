package in.mahabhujal.mahabhujal.model;

public class RainDataModel {
String stationId;
    String rainfall;

    public RainDataModel(String stationId, String rainfall, String date) {
        this.stationId = stationId;
        this.rainfall = rainfall;
        this.date = date;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;



}
