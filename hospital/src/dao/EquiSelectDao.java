package dao;

import entity.EquiSelect_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquiSelectDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List equiSelect_select(String sql, EquiSelect_select equiSelect_select) {
        return jdbcTemplate.queryForList(sql,equiSelect_select.getBdate(),equiSelect_select.getEdate(),equiSelect_select.getCard_no(),equiSelect_select.getEqui_code(),
                                              equiSelect_select.getVendor(),equiSelect_select.getStore(),equiSelect_select.getState(),equiSelect_select.getEqui_type()
                                               ,equiSelect_select.getPrin_emp());
    }
}
