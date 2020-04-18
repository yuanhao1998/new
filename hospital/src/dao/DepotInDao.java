package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.DepotIn_insert;
import entity.DepotIn_detail_insert;
import entity.DepotIn_select;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepotInDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询
    public List Select(String sql, DepotIn_select depotIn_select) throws SQLException {
        return jdbcTemplate.queryForList(sql,depotIn_select.getBdate(),depotIn_select.getEdate(),depotIn_select.getIn_id(),depotIn_select.getVendor(),depotIn_select.getStore(),depotIn_select.getState(),depotIn_select.getCreate());
    }

    //添加
    public int Insert(String sql, DepotIn_insert depotInInsert)throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner(ds);
        //{ depotInInsert.getInsert_no(),depotInInsert.getInsert_date(),depotInInsert.getVendor(),depotInInsert.getStore(),depotInInsert.getCreate()};
        //System.out.println(sql);
        return runner.update(sql,depotInInsert.getIn_insert_no(),depotInInsert.getStore(),depotInInsert.getVendor(),depotInInsert.getBuyer(),
                                 depotInInsert.getCreate_emp(),depotInInsert.getInsert_date(),depotInInsert.getState(),depotInInsert.getMaker());
    }

    //删除
    public  int Delete(String sql,String id)  {
        return jdbcTemplate.update(sql,id);
    }

    //审核
    public int Audit(String sql, String id,String user) throws SQLException {
        return jdbcTemplate.update(sql,id,user);
    }

    //消审
    public int Remove(String sql, String id) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner(ds);
        return runner.update(sql,id);
    }

    //生成卡片
    public int create_card(String sql, String id) {
        return jdbcTemplate.update(sql,id);
    }

    //详情页查询
    public List<Object[]> Detail_select(String sql, String in_no) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner(ds);
        //System.out.println(sql+id);
        return runner.query(sql,new ArrayListHandler(),in_no);
    }


    //详情页插入
    public int Detail_insert(String sql, DepotIn_detail_insert ddi) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner(ds);
        return runner.update(sql,ddi.getIn_no(),ddi.getEqui_code(),ddi.getMoney_source(),ddi.getPrice(),ddi.getAmount(),ddi.getMaker());
    }

    //详情页删除
    public int Detail_delete(String sql, String id) throws SQLException {
//        DataSource ds = new ComboPooledDataSource();
//        QueryRunner runner = new QueryRunner(ds);
//        return runner.update(sql,id);
        return jdbcTemplate.update(sql,id);
    }
}
