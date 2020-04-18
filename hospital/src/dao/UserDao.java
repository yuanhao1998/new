package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List login(String name, String password){
        String sql = "select * from sys_user where user_code = ? and password = ?";
        return   jdbcTemplate.queryForList(sql,name,password);
    }
}
