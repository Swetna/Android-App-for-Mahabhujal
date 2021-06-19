package in.mahabhujal.mahabhujal.model;

public class RainStationModel {
    String date;
     String rainId;
    String volunteername;
   String lat;

    public RainStationModel(String date, String rainId, String volunteername, String lat, String longi, String address) {
        this.date = date;
        this.rainId = rainId;
        this.volunteername = volunteername;
        this.lat = lat;
        this.longi = longi;
        this.address = address;
    }

    String longi;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRainId() {
        return rainId;
    }

    public void setRainId(String rainId) {
        this.rainId = rainId;
    }

    public String getVolunteername() {
        return volunteername;
    }

    public void setVolunteername(String volunteername) {
        this.volunteername = volunteername;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;


}
