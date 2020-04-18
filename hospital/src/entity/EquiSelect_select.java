package entity;

public class EquiSelect_select {
    private String bdate;
    private String edate;
    private String card_no;
    private String equi_code;
    private String vendor;
    private String store;
    private String state;
    private String equi_type;
    private String prin_emp;
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

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getEqui_code() {
        return equi_code;
    }

    public void setEqui_code(String equi_code) {
        this.equi_code = equi_code;
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

    public String getEqui_type() {
        return equi_type;
    }

    public void setEqui_type(String equi_type) {
        this.equi_type = equi_type;
    }

    public String getPrin_emp() {
        return prin_emp;
    }

    public void setPrin_emp(String prin_emp) {
        this.prin_emp = prin_emp;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "EquiSelect_select{" +
                "bdate='" + bdate + '\'' +
                ", edate='" + edate + '\'' +
                ", card_no='" + card_no + '\'' +
                ", equi_code='" + equi_code + '\'' +
                ", vendor='" + vendor + '\'' +
                ", store='" + store + '\'' +
                ", state='" + state + '\'' +
                ", equi_type='" + equi_type + '\'' +
                ", prin_emp='" + prin_emp + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
