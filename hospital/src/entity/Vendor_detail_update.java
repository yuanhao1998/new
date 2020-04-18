package entity;

public class Vendor_detail_update {
    private String ven_code;
    private String ven_name;
    private String ven_type;
    private String address;
    private String postcode;
    private String legal_person;
    private String business_charter;
    private String ven_bank;
    private String ven_bank_account;
    private String ven_phone;
    private String is_stop;
    private String src;

    public String getVen_code() {
        return ven_code;
    }

    public void setVen_code(String ven_code) {
        this.ven_code = ven_code;
    }

    public String getVen_name() {
        return ven_name;
    }

    public void setVen_name(String ven_name) {
        this.ven_name = ven_name;
    }

    public String getVen_type() {
        return ven_type;
    }

    public void setVen_type(String ven_type) {
        this.ven_type = ven_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }

    public String getBusiness_charter() {
        return business_charter;
    }

    public void setBusiness_charter(String business_charter) {
        this.business_charter = business_charter;
    }

    public String getVen_bank() {
        return ven_bank;
    }

    public void setVen_bank(String ven_bank) {
        this.ven_bank = ven_bank;
    }

    public String getVen_bank_account() {
        return ven_bank_account;
    }

    public void setVen_bank_account(String ven_bank_account) {
        this.ven_bank_account = ven_bank_account;
    }

    public String getVen_phone() {
        return ven_phone;
    }

    public void setVen_phone(String ven_phone) {
        this.ven_phone = ven_phone;
    }

    public String getIs_stop() {
        return is_stop;
    }

    public void setIs_stop(String is_stop) {
        this.is_stop = is_stop;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Vendor_detail_update{" +
                "ven_code='" + ven_code + '\'' +
                ", ven_name='" + ven_name + '\'' +
                ", ven_type='" + ven_type + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", legal_person='" + legal_person + '\'' +
                ", business_charter='" + business_charter + '\'' +
                ", ven_bank='" + ven_bank + '\'' +
                ", ven_bank_account='" + ven_bank_account + '\'' +
                ", ven_phone='" + ven_phone + '\'' +
                ", is_stop='" + is_stop + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
