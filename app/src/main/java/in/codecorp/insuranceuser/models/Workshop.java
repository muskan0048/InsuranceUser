package in.codecorp.insuranceuser.models;

public class Workshop {

    String name;
    String address;
    String lat;
    String lng;
    String email;
    String phone;
    String mobile;

    public Workshop(String name, String address, String lat, String lng, String email, String phone, String mobile) {
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
