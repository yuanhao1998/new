package controller;

import entity.DepotIn_detail_insert;
import entity.DepotIn_select;
import entity.DepotIn_insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepotInService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/depotIn")
public class depotInController {
    @Autowired
    DepotInService depotInService;

    //引入的xml文件
    String xmlPath = "DepotInSQL.xml";


    //将从数据库获得的数据转换成list
    public List getResult(List<Object[]> result){
        //循环读取数据，添加到list
        List list = new ArrayList();
        for(Object[] objs : result){
            for(Object obj : objs){
                list.add(obj);
            }
        }
        return list;
    }

    //查询入库单
    @RequestMapping("/select")
    public String depotIn_select(DepotIn_select  depotIn_select, Model model) throws SQLException {
        //截取编码
        if (depotIn_select.getVendor().isEmpty()!=true ){ depotIn_select.setVendor(depotIn_select.getVendor().substring(0,4)); }
        if (depotIn_select.getStore().isEmpty()!=true){ depotIn_select.setStore(depotIn_select.getStore().substring(0,4)); }
        //System.out.println(depotIn_select.toString());
        //接收查询到的数据
        List result = depotInService.depotIn_Select(xmlPath,depotIn_select.getSrc(),depotIn_select);
        //将list转为二维数组
        String[][] form = new String[result.size()][9];
        //System.out.println(result.toString());
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("in_no"));
            form[i][1]= String.valueOf(map.get("store_name"));
            form[i][2]= String.valueOf(map.get("ven_name"));
            form[i][3]= String.valueOf(map.get("buyer"));
            form[i][4]= String.valueOf(map.get("create_emp"));
            form[i][5]= String.valueOf(map.get("create_date").toString().substring(0,10));
            form[i][6]= String.valueOf(map.get("state"));
            form[i][7]= String.valueOf(map.get("audit_emp"));
            form[i][8]= String.valueOf(map.get("maker"));
        }
        model.addAttribute("result",form);
        return "depot/in/main";
    }


    //添加入库单
    @RequestMapping("/insert")
    public String depotIn_Insert( DepotIn_insert depotIn_insert,Model model) throws SQLException {
        if (depotIn_insert.getVendor().isEmpty()!=true){ depotIn_insert.setVendor(depotIn_insert.getVendor().substring(0,4)); }
        if (depotIn_insert.getStore().isEmpty()!=true){ depotIn_insert.setStore(depotIn_insert.getStore().substring(0,4)); }
        String state = "添加失败！";
       String success = depotInService.depotIn_Insert(xmlPath,depotIn_insert);
       if (success.equals("1")){
           state = "添加成功！";
       }
//        System.out.println(depotInInsert.toString());
        model.addAttribute("state",state);
       return "depot/in/insert";
    }



    //删除入库单，前台使用ajax传过来id和src
    @RequestMapping("/delete")
    public @ResponseBody int depotIn_Delete(String id, String src) throws SQLException {
        //System.out.println(id+src);
        int state = depotInService.delete(xmlPath,src,id);
        return state;
    }


    //审核   前台使用Ajax传过来id和src
    @RequestMapping("/audit")
    public @ResponseBody int depotIn_Audit(String id, String src, String user) throws SQLException {
        int state = depotInService.audit(xmlPath,src,id,user);
        return state;
    }


    //消审  Ajax
    @RequestMapping("/remove")
    public @ResponseBody int depotIn_Remove(String id, String src) throws SQLException {
        int state = depotInService.remove(xmlPath,src,id);
        return state;
    }


    //生成卡片
    @RequestMapping("/create_card")
    public @ResponseBody int depotIn_Create_card(String id,String src){
        return depotInService.create_card(xmlPath,src,id);
    }

    //详情页查询
    @RequestMapping("/detail_select")
    public @ResponseBody
    String[][] depotIn_detail_select(String in_no,String src) throws SQLException {
        List<Object[]> result = depotInService.detail_select(xmlPath,src,in_no);
        List list = getResult(result);
        //将list转为二维数组
        String[][] form = new String[list.size()][6];
        int x = 0;
        for (int i = 0; i<list.size();){
            for (int j=0;j<6;j++){
                form[x][j]= String.valueOf(list.get(i));
                i++;
            }
            x++;
        }
        //System.out.println(form[0][0]);
        //model.addAttribute("result",form);
        return form;
    }


    //详情页添加
    @RequestMapping("/detail_insert")
    public String depotIn_detail_insert(DepotIn_detail_insert ddi,Model model) throws SQLException {
         if (ddi.getEqui_code().isEmpty()!=true){ ddi.setEqui_code(ddi.getEqui_code().substring(0,8)); }
         ddi.setMoney_source(ddi.getMoney_source().substring(0,1));
        String state = "添加失败！";
        String success=depotInService.detail_insert(xmlPath,ddi);
        if (success.equals("1")){
            state = "添加成功！";
        }
        model.addAttribute("state",state);
        return "depot/in/detail_insert";
    }

    //详情页删除
    @RequestMapping("/detail_delete")
    public @ResponseBody int depotIn_detail_delete(String id, String src) throws SQLException {
        //System.out.println(id+src);
        int state = depotInService.detail_delete(xmlPath,src,id);
        return state;
    }

}
