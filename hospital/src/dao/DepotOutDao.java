package dao;

import entity.DepotOut_insert;
import entity.DepotOut_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class DepotOutDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询
    public List select(String sql, DepotOut_select depotOutSelect) throws SQLException {
//        DataSource ds = new ComboPooledDataSource();
//        QueryRunner runner = new QueryRunner(ds);
//        return runner.query(sql,new ArrayListHandler(),depotOutSelect.getId());
        //System.out.println(depotOutSelect.toString());
        return  jdbcTemplate.queryForList(sql,depotOutSelect.getBdate(),depotOutSelect.getEdate(),depotOutSelect.getOut_no(),depotOutSelect.getVendor(),depotOutSelect.getStore(),depotOutSelect.getState(),depotOutSelect.getCreate());
    }

    public String insert(String sql, DepotOut_insert depotOutInsert) {
        return String.valueOf(jdbcTemplate.update(sql,depotOutInsert.getOut_insert_no(),depotOutInsert.getInsert_date(),depotOutInsert.getStore(),depotOutInsert.getVendor(),depotOutInsert.getCreate_emp(),depotOutInsert.getMaker(),depotOutInsert.getState()));
    }

    public int delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
//        System.out.println(sql+id);
//        return 0;
    }

    public int audit(String sql, String id, String user) {
        //System.out.println(jdbcTemplate.update(sql,user,id));
        return jdbcTemplate.update(sql,user,id);
//        System.out.println(sql+id+user);
//        return 0;
    }

    public int remove(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    public List detail_select(String sql, String out_no) {
        return jdbcTemplate.queryForList(sql,out_no);
//        System.out.println(sql+out_no);
//        return 0;
    }

    public int detail_insert(String sql, String out_no, String card_no) {
        //System.out.println(sql+out_no+card_no);
        return jdbcTemplate.update(sql,out_no,card_no);
    }

    public List detail_insert_select(String sql, String out_no, String card_no) {
        return jdbcTemplate.queryForList(sql,out_no,card_no);
    }


    public int detail_delete(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }
}
