package service;

import dao.EquiSelectDao;
import entity.EquiSelect_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquiSelectService {
    @Autowired
    EquiSelectDao equiSelectDao;
    @Autowired
    ReadXML readXML;

    public List equiSelect_select(String xmlPath, EquiSelect_select equiSelect_select) {
        String sql = readXML.getSql(xmlPath,equiSelect_select.getSrc());
        return equiSelectDao.equiSelect_select(sql,equiSelect_select);
    }
}
