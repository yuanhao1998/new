package service;

import dao.DepotOutDao;
import entity.DepotOut_insert;
import entity.DepotOut_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DepotOutService {
    @Autowired
    DepotOutDao depotOutDao;
    @Autowired
    ReadXML readXML;

    //查询
    public List select(String xmlPath, DepotOut_select depotOutSelect) throws SQLException {
        String sql = readXML.getSql(xmlPath,depotOutSelect.getSrc());
//        List list = depotOutDao.select(sql,depotOutSelect);
//        System.out.println(list.toString());
        return depotOutDao.select(sql,depotOutSelect);
    }

    public String insert(String xmlPath, DepotOut_insert depotOutInsert) {
        String sql = readXML.getSql(xmlPath,depotOutInsert.getSrc());
        return depotOutDao.insert(sql,depotOutInsert);
    }

    public int delete(String xmlPath, String src, String id) {
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.delete(sql,id);
    }

    public int audit(String xmlPath,String src, String id, String user) {
        String sql = readXML.getSql(xmlPath,src);
        return depotOutDao.audit(sql,id,user);
    }

    public int remove(String xmlPath, String src, String id) {
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.remove(sql,id);
    }

    public List detail_select(String xmlPath, String out_no, String src) {
        //System.out.println(src);
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.detail_select(sql,out_no);
    }

    public int detail_insert(String xmlPath, String out_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.detail_insert(sql,out_no,card_no);
    }

    public List detail_insert_select(String xmlPath, String out_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.detail_insert_select(sql,out_no,card_no);
    }

    public int detail_delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotOutDao.detail_delete(sql,id);
    }
}
