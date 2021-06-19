package in.mahabhujal.mahabhujal.model;

public class BorewellWaterLevelModel {
    String borewellid;
    String date;
    String available;
    String variation;
    String preWaterLevel;
    String potentWaterLevel;


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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getPreWaterLevel() {
        return preWaterLevel;
    }

    public void setPreWaterLevel(String preWaterLevel) {
        this.preWaterLevel = preWaterLevel;
    }

    public String getPostWaterLevel() {
        return postWaterLevel;
    }

    public void setPostWaterLevel(String postWaterLevel) {
        this.postWaterLevel = postWaterLevel;
    }

    public String getPotentWaterLevel() {
        return potentWaterLevel;
    }

    public void setPotentWaterLevel(String potentWaterLevel) {
        this.potentWaterLevel = potentWaterLevel;
    }

    String postWaterLevel;

    public BorewellWaterLevelModel(String borewellid, String date, String available, String variation, String preWaterLevel, String postWaterLevel, String potentWaterLevel) {
        this.borewellid = borewellid;
        this.date = date;
        this.available = available;
        this.variation = variation;
        this.preWaterLevel = preWaterLevel;
        this.postWaterLevel = postWaterLevel;
        this.potentWaterLevel = potentWaterLevel;
    }


}
