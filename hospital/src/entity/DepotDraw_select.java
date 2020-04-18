package entity;

public class DepotDraw_select {
    private String bdate;
    private String edate;
    private String draw_no;
    private String dept;
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

    public String getDraw_no() {
        return draw_no;
    }

    public void setDraw_no(String draw_no) {
        this.draw_no = draw_no;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
        return "DepotDraw_select{" +
                "bdate='" + bdate + '\'' +
                ", edate='" + edate + '\'' +
                ", draw_no='" + draw_no + '\'' +
                ", dept='" + dept + '\'' +
                ", store='" + store + '\'' +
                ", state='" + state + '\'' +
                ", create='" + create + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
