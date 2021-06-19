package in.mahabhujal.mahabhujal.model;

public class RechargeStructAddModel {
    String type,lat,longi;
    String date,area;

    public RechargeStructAddModel(String type, String lat, String longi, String date, String area) {
        this.type = type;
        this.lat = lat;
        this.longi = longi;
        this.date = date;
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
