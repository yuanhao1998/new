package entity;

public class EquiScrap_select {
    private String bdate;
    private String edate;
    private String scrap_no;
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

    public String getScrap_no() {
        return scrap_no;
    }

    public void setScrap_no(String scrap_no) {
        this.scrap_no = scrap_no;
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
        return "EquiScrap_select{" +
                "bdate='" + bdate + '\'' +
                ", edate='" + edate + '\'' +
                ", scrap_no='" + scrap_no + '\'' +
                ", state='" + state + '\'' +
                ", create='" + create + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
