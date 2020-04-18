package dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class TipsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List  get_tips(String sql,String user) throws SQLException {

        //System.out.println(sql+user);
        List result = jdbcTemplate.queryForList(sql,user);
        //接收查询的结果

        return result;
    }
}
