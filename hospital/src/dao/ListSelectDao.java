package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListSelectDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List equi_month_select(String sql, String month, String store) {
        //System.out.println(month+store+jdbcTemplate.queryForList(sql,month,store));
        return jdbcTemplate.queryForList(sql,month,store);
    }

    public List equi_in_detail(String sql, String month, String store) {
        return jdbcTemplate.queryForList(sql,month,store);
    }

    public List dept_draw_list(String sql, String month, String store) {
        return jdbcTemplate.queryForList(sql,month,store);
    }
}
