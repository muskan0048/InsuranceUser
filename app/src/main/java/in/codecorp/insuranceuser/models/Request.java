package in.codecorp.insuranceuser.models;

public class Request {

    String reqid;
    String vNumber;
    String workshopId;

    public String getReqid() {
        return reqid;
    }

    public void setReqid(String reqid) {
        this.reqid = reqid;
    }

    public String getvNumber() {
        return vNumber;
    }

    public void setvNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public String getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(String workshopId) {
        this.workshopId = workshopId;
    }

    public Request(String reqid, String vNumber, String workshopId) {
        this.reqid = reqid;
        this.vNumber = vNumber;
        this.workshopId = workshopId;
    }
}
