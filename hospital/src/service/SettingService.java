package service;

import dao.SettingDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {
    @Autowired
    SettingDao settingDao;
    @Autowired
    ReadXML readXML;

    public List vendor_select(String xmlPath, String ven_name, String ven_code, String ven_type, String src) {
        String sql = readXML.getSql(xmlPath,src);
        return settingDao.vendor_select(sql,ven_name,ven_code,ven_type);
    }

    public int vendor_insert(String xmlPath, Vendor_insert vendor_insert) {
        String sql = readXML.getSql(xmlPath,vendor_insert.getSrc());
        return settingDao.vendor_insert(sql,vendor_insert);
    }

    public int vendor_delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return settingDao.vendor_delete(sql,id);
    }

    public List vendor_detail_select(String xmlPath,String src,  String id) {
        String sql = readXML.getSql(xmlPath, src);
        return settingDao.vendor_detail_select(sql,id);
    }

    public String vendor_detail_update(String xmlPath, Vendor_detail_update vendor_detail_update) {
        String sql = readXML.getSql(xmlPath,vendor_detail_update.getSrc());
        return settingDao.vendor_detail_update(sql,vendor_detail_update);
    }

    public List dept_select(String xmlPath, String dept_code, String dept_name, String src) {
        String sql = readXML.getSql(xmlPath,src);
        return  settingDao.dept_select(sql,dept_code,dept_name);
    }


    public String dept_insert(String xmlPath, Dept_insert dept_insert) {
        String sql = readXML.getSql(xmlPath,dept_insert.getSrc());
        return settingDao.dept_insert(sql,dept_insert);
    }

    public int dept_delete(String xmlPath, String src, String id) {
        String sql = readXML.getSql(xmlPath,src);
        return settingDao.dept_delete(sql,id);
    }

    public Integer dept_select_state(String id) {
        return settingDao.dept_select_state(id);
    }

    public int dept_update_state(String id, Integer state) {
        return settingDao.dept_update_state(id,state);
    }

    public List equi_select(String xmlPath, String equi_code, String equi_name, String equi_type, String src) {
        String sql =readXML.getSql(xmlPath,src);
        return settingDao.equi_select(sql,equi_code,equi_name,equi_type);
    }

    public int equi_insert(String xmlPath, Equi_insert equi_insert) {
        String sql = readXML.getSql(xmlPath,equi_insert.getSrc());
        return settingDao.equi_insert(sql,equi_insert);
    }

    public int equi_delete(String xmlPath, String id, String src) {
        String sql = readXML.getSql(xmlPath, src);
        return settingDao.equi_delete(sql,id);
    }

    public Integer equi_select_state(String id) {
        return settingDao.equi_select_state(id);
    }

    public int equi_update_state(String id, Integer state) {
        return settingDao.equi_update_state(id,state);
    }

}
