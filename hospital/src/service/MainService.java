package service;

import dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    MainDao mainDao;
    @Autowired
    ReadXML readXML;

    public Integer get_auto_number(String xmlPath, String src) {
        String sql = readXML.getSql(xmlPath, src);
        //System.out.println(src+sql);
        return mainDao.get_auto_number(sql);
    }

    public List get_option( String xmlPath, String value,String src) {
        String sql = readXML.getSql(xmlPath,src);
        return mainDao.get_option(sql,value);
    }
}
