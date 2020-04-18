package dao;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SettingDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List vendor_select(String sql, String ven_name, String ven_code, String ven_type) {
        return jdbcTemplate.queryForList(sql,ven_name,ven_code,ven_type);
    }

    public int vendor_insert(String sql, Vendor_insert vendor_insert) {
        return jdbcTemplate.update(sql,vendor_insert.getVen_code(),vendor_insert.getVen_name(),vendor_insert.getVen_type(),vendor_insert.getVen_address(),
                                        vendor_insert.getVen_postcode(),vendor_insert.getLegal_person(),vendor_insert.getBusiness_charter(),
                                        vendor_insert.getVen_bank(),vendor_insert.getVen_bank_account(),vendor_insert.getVen_phone());
    }

    public int vendor_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public List vendor_detail_select(String sql, String id) {
        return jdbcTemplate.queryForList(sql,id);
    }

    public List dept_select(String sql, String dept_code, String dept_name) {
        return jdbcTemplate.queryForList(sql,dept_code,dept_name);
    }


    public String vendor_detail_update(String sql, Vendor_detail_update vendor_detail_update) {
        return String.valueOf(jdbcTemplate.update(sql,vendor_detail_update.getVen_name(),vendor_detail_update.getAddress(), vendor_detail_update.getPostcode(),
                                       vendor_detail_update.getLegal_person(),vendor_detail_update.getBusiness_charter(),vendor_detail_update.getVen_bank(),
                                       vendor_detail_update.getVen_bank_account(),vendor_detail_update.getVen_phone(),vendor_detail_update.getIs_stop(),vendor_detail_update.getVen_code()));

    }

    public String dept_insert(String sql, Dept_insert dept_insert) {
        return String.valueOf(jdbcTemplate.update(sql,dept_insert.getDept_code(),dept_insert.getDept_name(),dept_insert.getSpell(),dept_insert.getDept_level(),dept_insert.getSuper_code()));
    }

    public int dept_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public Integer dept_select_state(String id) {
        return jdbcTemplate.queryForObject("select is_stop from dbo.sys_dept where dept_code = ?",Integer.class,id);
    }

    public int dept_update_state(String id, Integer state) {
        return jdbcTemplate.update("update dbo.sys_dept set is_stop=? where dept_code=?",state,id);
    }

    public List equi_select(String sql, String equi_code, String equi_name, String equi_type) {
        return jdbcTemplate.queryForList(sql,equi_code,equi_name,equi_type);
    }

    public int equi_insert(String sql, Equi_insert equi_insert) {
        return jdbcTemplate.update(sql,equi_insert.getEqui_code(),equi_insert.getEqui_name(),equi_insert.getSpell(),equi_insert.getEqui_type(),equi_insert.getUnit(),equi_insert.getEqui_model());
    }

    public int equi_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public Integer equi_select_state(String id) {
        return jdbcTemplate.queryForObject("select is_stop from dbo.equi_dict where equi_code = ?",Integer.class,id);
    }

    public int equi_update_state(String id, Integer state) {
        return jdbcTemplate.update("update equi_dict set is_stop=? where equi_code=?",state,id);
    }
}
