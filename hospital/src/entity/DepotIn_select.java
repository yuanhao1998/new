package entity;



public class DepotIn_select {
    private String bdate;
    private String edate;
    private String in_id;   //单号
    private String vendor;
    private String store;
    private String state;
    private String create;
    private String src;

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "DepotIn_select{" +
                "bdate='" + bdate + '\'' +
                ", edate='" + edate + '\'' +
                ", in_id='" + in_id + '\'' +
                ", vendor='" + vendor + '\'' +
                ", store='" + store + '\'' +
                ", state='" + state + '\'' +
                ", create='" + create + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
