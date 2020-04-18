package service;

import dao.ListSelectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSelectService {
    @Autowired
    ReadXML readXML;
    @Autowired
    ListSelectDao listSelectDao;

    public List equi_month_select(String xmlPath, String month, String store, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return listSelectDao.equi_month_select(sql,month,store);
    }

    public List equi_in_detail(String xmlPath, String month, String store, String src) {
        String  sql = readXML.getSql(xmlPath, src);
        return  listSelectDao.equi_in_detail(sql,month,store);
    }

    public List dept_draw_list(String xmlPath, String month, String store, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return listSelectDao.dept_draw_list(sql,month,store);
    }
}
