package service;

import dao.DepotInDao;
import entity.DepotIn_insert;
import entity.DepotIn_detail_insert;
import entity.DepotIn_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepotInService {
    @Autowired
    ReadXML readXML;
    @Autowired
    DepotInDao depotInDao;

    //查询入库单
    public List depotIn_Select(String xmlPath, String src, DepotIn_select depotIn_select) throws SQLException {
        List result = new ArrayList();
        String sql = readXML.getSql(xmlPath, src);
            //System.out.println("123");
        return depotInDao.Select(sql,depotIn_select);
    }

    //添加入库单  0表示添加失败，1表示添加成功
    public String depotIn_Insert(String xmlPath,DepotIn_insert depotInInsert) throws SQLException {
        String sql = readXML.getSql(xmlPath, depotInInsert.getSrc());
        if (sql=="error") {
            return "找不到这段SQL";
        }
        else {
            //System.out.println("123");
           return String.valueOf(depotInDao.Insert(sql,depotInInsert));
        }
    }


    //删除入库单
    public int delete(String xmlPath, String src, String id) throws SQLException {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.Delete(sql,id);
//        System.out.println(sql);
    }


    //审核 0：新建      1：审核        2：消审       3：生成卡片
    public int audit(String xmlPath, String src, String id, String user) throws SQLException {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.Audit(sql,id,user);
    }


    //消审
    public int remove(String xmlPath, String src, String id) throws SQLException {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.Remove(sql,id);
    }

    //生成卡片
    public int create_card(String xmlPath, String src, String id) {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.create_card(sql,id);
    }

    //详情页查询
    public List<Object[]> detail_select(String xmlPath, String src, String in_no) throws SQLException {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.Detail_select(sql,in_no);
    }

    //详情页插入
    public String detail_insert(String xmlPath, DepotIn_detail_insert ddi) throws SQLException {
        String sql = readXML.getSql(xmlPath,ddi.getSrc());
        if (sql=="error") {
            return "找不到这段SQL";
        }
        else {
            //System.out.println("123");
            return String.valueOf(depotInDao.Detail_insert(sql,ddi));
        }
    }

    //详情页删除
    public int detail_delete(String xmlPath, String src, String id) throws SQLException {
        String sql = readXML.getSql(xmlPath, src);
        return depotInDao.Detail_delete(sql,id);
    }

}
