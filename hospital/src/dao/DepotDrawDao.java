package dao;

import entity.DepotDraw_insert;
import entity.DepotDraw_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepotDrawDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List select(String sql, DepotDraw_select depotDraw_select) {
        //System.out.println(depotDraw_select.toString());
        return jdbcTemplate.queryForList(sql,depotDraw_select.getBdate(),depotDraw_select.getEdate(),depotDraw_select.getDraw_no(),depotDraw_select.getDept(),depotDraw_select.getStore(),depotDraw_select.getState(),depotDraw_select.getCreate());
    }

    public int insert(String sql, DepotDraw_insert depotDraw_insert) {
        return jdbcTemplate.update(sql,depotDraw_insert.getDraw_insert_no(),depotDraw_insert.getStore(),depotDraw_insert.getDept(),depotDraw_insert.getCreate_emp(),depotDraw_insert.getDraw_date(),depotDraw_insert.getState(),depotDraw_insert.getMaker());
    }

    public int delete(String sql, String id) {
        //System.out.println(sql+id);
        return jdbcTemplate.update(sql,id);
    }

    public int audit(String sql, String id, String user) {
        //System.out.println(sql+id+user);
        return jdbcTemplate.update(sql,user,id);
    }

    public int remove(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public List detail_insert_select(String sql, String draw_no, String card_no) {
        return jdbcTemplate.queryForList(sql,draw_no,card_no);
    }

    public int detail_insert(String sql, String draw_no, String card_no) {
        //System.out.println(sql+draw_no+card_no);
        return jdbcTemplate.update(sql,draw_no,card_no);
    }

    public List detail_select(String sql, String draw_no) {
        return jdbcTemplate.queryForList(sql,draw_no);
    }

    public int detail_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }
}
