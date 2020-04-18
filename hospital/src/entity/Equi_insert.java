package entity;

public class Equi_insert {
    private String equi_code;
    private String equi_name;
    private String spell;
    private String equi_type;
    private String unit;
    private String equi_model;
    private String src;

    public String getEqui_code() {
        return equi_code;
    }

    public void setEqui_code(String equi_code) {
        this.equi_code = equi_code;
    }

    public String getEqui_name() {
        return equi_name;
    }

    public void setEqui_name(String equi_name) {
        this.equi_name = equi_name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getEqui_type() {
        return equi_type;
    }

    public void setEqui_type(String equi_type) {
        this.equi_type = equi_type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEqui_model() {
        return equi_model;
    }

    public void setEqui_model(String equi_model) {
        this.equi_model = equi_model;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Equi_insert{" +
                "equi_code='" + equi_code + '\'' +
                ", equi_name='" + equi_name + '\'' +
                ", spell='" + spell + '\'' +
                ", equi_type='" + equi_type + '\'' +
                ", unit='" + unit + '\'' +
                ", equi_model='" + equi_model + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
