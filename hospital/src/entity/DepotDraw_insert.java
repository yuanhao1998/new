package entity;

public class DepotDraw_insert {
    private String draw_insert_no;
    private String draw_date;
    private String store;
    private String dept;
    private String create_emp;
    private String state;
    private String maker;
    private String src;

    public String getDraw_insert_no() {
        return draw_insert_no;
    }

    public void setDraw_insert_no(String draw_insert_no) {
        this.draw_insert_no = draw_insert_no;
    }

    public String getDraw_date() {
        return draw_date;
    }

    public void setDraw_date(String draw_date) {
        this.draw_date = draw_date;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
        return "DepotDraw_insert{" +
                "draw_insert_no='" + draw_insert_no + '\'' +
                ", draw_date='" + draw_date + '\'' +
                ", store='" + store + '\'' +
                ", dept='" + dept + '\'' +
                ", create_emp='" + create_emp + '\'' +
                ", state='" + state + '\'' +
                ", maker='" + maker + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
