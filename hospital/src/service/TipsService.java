package service;

import dao.TipsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipsService {
    @Autowired
    TipsDao tipsDao;
    @Autowired
    ReadXML readXML;

    public List get_tips(String xmlPath,String src,String user) throws SQLException {
        String sql=readXML.getSql(xmlPath, src);
        List result=tipsDao.get_tips(sql,user);
        return result;
    }
}
