package entity;

public class DepotIn_insert {
    private String in_insert_no;
    private String insert_date;
    private String vendor;
    private String store;
    private String buyer;
    private String create_emp;
    private String state;
    private String maker;
    private String src;

    public String getIn_insert_no() {
        return in_insert_no;
    }

    public void setIn_insert_no(String in_insert_no) {
        this.in_insert_no = in_insert_no;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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
        return "DepotIn_insert{" +
                "in_insert_no='" + in_insert_no + '\'' +
                ", insert_date='" + insert_date + '\'' +
                ", vendor='" + vendor + '\'' +
                ", store='" + store + '\'' +
                ", buyer='" + buyer + '\'' +
                ", create_emp='" + create_emp + '\'' +
                ", state='" + state + '\'' +
                ", maker='" + maker + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
