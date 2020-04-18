package entity;

public class DepotOut_insert {
    private String out_insert_no;
    private String insert_date;
    private String store;
    private String vendor;
    private String create_emp;
    private String state;
    private String maker;
    private String src;

    public String getOut_insert_no() {
        return out_insert_no;
    }

    public void setOut_insert_no(String out_insert_no) {
        this.out_insert_no = out_insert_no;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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
        return "DepotOut_insert{" +
                "out_insert_no='" + out_insert_no + '\'' +
                ", insert_date='" + insert_date + '\'' +
                ", store='" + store + '\'' +
                ", vendor='" + vendor + '\'' +
                ", create_emp='" + create_emp + '\'' +
                ", state='" + state + '\'' +
                ", maker='" + maker + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
