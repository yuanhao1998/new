package service;

import dao.DepotDrawDao;
import entity.DepotDraw_insert;
import entity.DepotDraw_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotDrawService {
    @Autowired
    ReadXML readXML;
    @Autowired
    DepotDrawDao depotDrawDao;

    public List select(String xmlPath, DepotDraw_select depotDraw_select) {
        String sql = readXML.getSql(xmlPath,depotDraw_select.getSrc());
        return depotDrawDao.select(sql,depotDraw_select);
    }

    public int insert(String xmlPath, DepotDraw_insert depotDraw_insert) {
        String sql = readXML.getSql(xmlPath,depotDraw_insert.getSrc());
        return depotDrawDao.insert(sql,depotDraw_insert);
    }

    public int delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.delete(sql,id);
    }

    public int audit(String xmlPath, String id, String src, String user) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.audit(sql,id,user);
    }

    public int remove(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.remove(sql,id);
    }

    public List detail_insert_select(String xmlPath, String draw_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.detail_insert_select(sql,draw_no,card_no);
    }

    public int detail_insert(String xmlPath, String draw_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.detail_insert(sql,draw_no,card_no);
    }

    public List detail_select(String xmlPath, String draw_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.detail_select(sql,draw_no);
    }

    public int detail_delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return depotDrawDao.detail_delete(sql,id);
    }
}
