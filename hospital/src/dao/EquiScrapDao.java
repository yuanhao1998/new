package dao;

import entity.EquiScrap_insert;
import entity.EquiScrap_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquiScrapDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List select(String sql, EquiScrap_select equiScrap_select) {
        return jdbcTemplate.queryForList(sql,equiScrap_select.getBdate(),equiScrap_select.getEdate(),equiScrap_select.getScrap_no(),equiScrap_select.getState(),equiScrap_select.getCreate());
    }

    public int insert(String sql, EquiScrap_insert equiScrap_insert) {
        return jdbcTemplate.update(sql,equiScrap_insert.getScrap_insert_no(),equiScrap_insert.getCreate_emp(),equiScrap_insert.getCreate_date(),equiScrap_insert.getState(),equiScrap_insert.getMaker());
    }

    public int delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public List detail_insert_select(String sql, String scrap_no, String card_no) {
        return jdbcTemplate.queryForList(sql,scrap_no,card_no);
    }

    public int detail_insert(String sql, String scrap_no, String card_no) {
        return jdbcTemplate.update(sql,scrap_no,card_no);
    }

    public List detail_select(String sql, String scrap_no) {
        return jdbcTemplate.queryForList(sql,scrap_no);
    }

    public int detail_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public int audit(String sql, String id, String user) {
        //System.out.println(sql+id+user);
        return jdbcTemplate.update(sql,id,user);
    }

    public int remove(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }
}
