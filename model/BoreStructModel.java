package in.mahabhujal.mahabhujal.model;

public class BoreStructModel {
    String level1,level2,level3;
    String B_code;

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

    public String getB_code() {
        return B_code;
    }

    public void setB_code(String b_code) {
        B_code = b_code;
    }




    public BoreStructModel(String level1, String level2, String level3, String b_code) {
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        B_code = b_code;
    }
}
