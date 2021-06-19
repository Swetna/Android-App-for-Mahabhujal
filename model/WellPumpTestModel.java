package in.mahabhujal.mahabhujal.model;

public class WellPumpTestModel {

String date;
    //String season;

    public String getNo_of_times() {
        return no_of_times;
    }

    public void setNo_of_times(String no_of_times) {
        this.no_of_times = no_of_times;
    }

    public WellPumpTestModel(String date, String season, String no_of_times, String crop, String area, String duration, String wellid, String method) {
        this.date = date;
        //this.season = season;
        this.no_of_times = no_of_times;
        this.crop = crop;
        this.area = area;
        this.duration = duration;
        this.wellid = wellid;
        this.method = method;
    }

    String no_of_times;

    String crop;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   /* public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

     */

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getWellid() {
        return wellid;
    }

    public void setWellid(String wellid) {
        this.wellid = wellid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    String area;
    String duration;
    String wellid;
    String method;


}
