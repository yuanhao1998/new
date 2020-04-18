package entity;

public class EquiScrap_insert {
    private String scrap_insert_no;
    private String create_date;
    private String create_emp;
    private String state;
    private String maker;
    private String src;

    public String getScrap_insert_no() {
        return scrap_insert_no;
    }

    public void setScrap_insert_no(String scrap_insert_no) {
        this.scrap_insert_no = scrap_insert_no;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String scrap_date) {
        this.create_date = scrap_date;
    }

    public String getCreate_emp() {
        return create_emp;
    }

    public void setCreate_emp(String create_emp) {
        this.create_emp = create_emp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "EquiScrap_insert{" +
                "scrap_insert_no='" + scrap_insert_no + '\'' +
                ", create_date='" + create_date + '\'' +
                ", create_emp='" + create_emp + '\'' +
                ", state='" + state + '\'' +
                ", maker='" + maker + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
