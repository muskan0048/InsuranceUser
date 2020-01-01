package in.codecorp.insuranceuser.models;

public class Vehicle {

    String vName;
    String vNumber;
    String vid;
    String vBrand;
    String uid;

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvNumber() {
        return vNumber;
    }

    public void setvNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getvBrand() {
        return vBrand;
    }

    public void setvBrand(String vBrand) {
        this.vBrand = vBrand;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Vehicle(String vName, String vNumber, String vid, String vBrand, String uid) {
        this.vName = vName;
        this.vNumber = vNumber;
        this.vid = vid;
        this.vBrand = vBrand;
        this.uid = uid;
    }
}
