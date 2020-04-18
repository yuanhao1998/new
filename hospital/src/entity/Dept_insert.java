package entity;

public class Dept_insert {
    private String dept_code;
    private String dept_name;
    private String spell;
    private String dept_level;
    private String super_code;
    private String src;

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getDept_level() {
        return dept_level;
    }

    public void setDept_level(String dept_level) {
        this.dept_level = dept_level;
    }

    public String getSuper_code() {
        return super_code;
    }

    public void setSuper_code(String super_code) {
        this.super_code = super_code;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Dept_insert{" +
                "dept_code='" + dept_code + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", spell='" + spell + '\'' +
                ", dept_level='" + dept_level + '\'' +
                ", super_code='" + super_code + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
