package in.codecorp.insuranceuser.models;

public class Accident {

    String aid;
    String[] images;
    String location;
    String insuranceUrl;
    String dlUrl;
    String adharUrl;
    String panUrl;
    String rcUrl;
    String ccUrl;
    String vid;
    String uid;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInsuranceUrl() {
        return insuranceUrl;
    }

    public void setInsuranceUrl(String insuranceUrl) {
        this.insuranceUrl = insuranceUrl;
    }

    public String getDlUrl() {
        return dlUrl;
    }

    public void setDlUrl(String dlUrl) {
        this.dlUrl = dlUrl;
    }

    public String getAdharUrl() {
        return adharUrl;
    }

    public void setAdharUrl(String adharUrl) {
        this.adharUrl = adharUrl;
    }

    public String getPanUrl() {
        return panUrl;
    }

    public void setPanUrl(String panUrl) {
        this.panUrl = panUrl;
    }

    public String getRcUrl() {
        return rcUrl;
    }

    public void setRcUrl(String rcUrl) {
        this.rcUrl = rcUrl;
    }

    public String getCcUrl() {
        return ccUrl;
    }

    public void setCcUrl(String ccUrl) {
        this.ccUrl = ccUrl;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Accident(String aid, String[] images, String location, String insuranceUrl, String dlUrl, String adharUrl, String panUrl, String rcUrl, String ccUrl, String vid, String uid) {
        this.aid = aid;
        this.images = images;
        this.location = location;
        this.insuranceUrl = insuranceUrl;
        this.dlUrl = dlUrl;
        this.adharUrl = adharUrl;
        this.panUrl = panUrl;
        this.rcUrl = rcUrl;
        this.ccUrl = ccUrl;
        this.vid = vid;
        this.uid = uid;
    }
}
