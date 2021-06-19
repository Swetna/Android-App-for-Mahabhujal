package in.mahabhujal.mahabhujal.model;

public class BorewellPumpModel {
    String borewellid;
    String date;
    String summer;

    public String getBorewellid() {
        return borewellid;
    }

    public void setBorewellid(String borewellid) {
        this.borewellid = borewellid;
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

    String monsoon;
    String winter;
    String discharge;

    public BorewellPumpModel(String borewellid, String date, String summer, String monsoon, String winter, String discharge) {
        this.borewellid = borewellid;
        this.date = date;
        this.summer = summer;
        this.monsoon = monsoon;
        this.winter = winter;
        this.discharge = discharge;
    }


}
