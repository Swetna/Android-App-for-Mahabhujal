package in.mahabhujal.mahabhujal.model;

public class WellStructModel {
    String level1,level2,level3;

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getWellid() {
        return wellid;
    }

    public void setWellid(String wellid) {
        this.wellid = wellid;
    }

    String wellid;


    public WellStructModel(String level1, String level2, String level3, String wellid) {
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.wellid = wellid;
    }







}
