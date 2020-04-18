package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer get_auto_number(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public List get_option( String sql,String value) {
       return jdbcTemplate.queryForList(sql,value);
    }
}
