package service;

import dao.EquiScrapDao;
import entity.EquiScrap_insert;
import entity.EquiScrap_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquiScrapService {
    @Autowired
    ReadXML readXML;
    @Autowired
    EquiScrapDao  equiScrapDao;

    public List select(String xmlPath, EquiScrap_select equiScrap_select) {
        String sql = readXML.getSql(xmlPath,equiScrap_select.getSrc());
        return equiScrapDao.select(sql,equiScrap_select);
    }

    public int insert(String xmlPath, EquiScrap_insert equiScrap_insert) {
        String sql = readXML.getSql(xmlPath,equiScrap_insert.getSrc());
        return  equiScrapDao.insert(sql,equiScrap_insert);
    }

    public int delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return  equiScrapDao.delete(sql,id);
    }

    public int detail_insert(String xmlPath, String scrap_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.detail_insert(sql,scrap_no,card_no);
    }

    public List detail_insert_select(String xmlPath, String scrap_no, String card_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.detail_insert_select(sql,scrap_no,card_no);
    }


    public List detail_select(String xmlPath, String scrap_no, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.detail_select(sql,scrap_no);
    }

    public int detail_delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.detail_delete(sql,id);
    }

    public int audit(String xmlPath, String src, String id, String user) {
        String  sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.audit(sql,id,user);
    }

    public int remove(String xmlPath, String src, String id) {
        String sql = readXML.getSql(xmlPath, src);
        return equiScrapDao.remove(sql,id);
    }
}
