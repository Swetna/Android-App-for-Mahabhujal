package in.mahabhujal.mahabhujal.model;

public class WellPumpModel {
    String wellid;

    public WellPumpModel(String wellid, String date, String summer, String monsoon, String winter, String discharge) {
        this.wellid = wellid;
        this.date = date;
        this.summer = summer;
        this.monsoon = monsoon;
        this.winter = winter;
        this.discharge = discharge;
    }

    String date;
    String summer;
    String monsoon;String winter;
    String discharge;

    public String getWellid() {
        return wellid;
    }

    public void setWellid(String wellid) {
        this.wellid = wellid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummer() {
        return summer;
    }

    public void setSummer(String summer) {
        this.summer = summer;
    }

    public String getMonsoon() {
        return monsoon;
    }

    public void setMonsoon(String monsoon) {
        this.monsoon = monsoon;
    }

    public String getWinter() {
        return winter;
    }

    public void setWinter(String winter) {
        this.winter = winter;
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }


}
