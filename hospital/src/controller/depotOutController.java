package controller;

import entity.DepotOut_insert;
import entity.DepotOut_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepotOutService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/depotOut")
public class depotOutController {
    @Autowired
    DepotOutService depotOutService;

    //引入的xml文件
    String xmlPath = "DepotOutSQL.xml";


    //查询
    @RequestMapping("/select")
    public String depot_out_select(DepotOut_select depotOutSelect, Model model) throws SQLException {
        if (depotOutSelect.getVendor().isEmpty()!=true){ depotOutSelect.setVendor(depotOutSelect.getVendor().substring(0,4)); }
        if (depotOutSelect.getStore().isEmpty()!=true){ depotOutSelect.setStore(depotOutSelect.getStore().substring(0,4)); }
        List result =depotOutService.select(xmlPath,depotOutSelect);
        //System.out.println(depotOutSelect.toString());
      //  System.out.println(result.toString());
//        Map map = (Map) result.get(0);
//        System.out.println(map.get("out_no"));
        String[][] form = new String[result.size()][8];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("out_no"));
            form[i][1]= String.valueOf(map.get("store_name"));
            form[i][2]= String.valueOf(map.get("ven_name"));
            form[i][3]= String.valueOf(map.get("out_emp"));
            form[i][4]= String.valueOf(map.get("out_date").toString().substring(0,10));//时间只需要截取年月日
            form[i][5]= String.valueOf(map.get("state"));
            form[i][6]= String.valueOf(map.get("audit_emp"));
            form[i][7]= String.valueOf(map.get("out_reason"));
        }
       // System.out.println(result.toString());
        model.addAttribute("result",form);
        return "depot/out/main";
    }

    //添加退库单
    @RequestMapping("/insert")
    public String depot_out_insert(DepotOut_insert depotOutInsert,Model model){
        if(depotOutInsert.getStore().isEmpty()!=true){ depotOutInsert.setStore(depotOutInsert.getStore().substring(0,4)); }
        if (depotOutInsert.getVendor().isEmpty()!=true){ depotOutInsert.setVendor(depotOutInsert.getVendor().substring(0,4)); }
        String success = depotOutService.insert(xmlPath,depotOutInsert);
        String state = "添加失败！";
        if (success.equals("1")){
            state = "添加成功！";
        }
        model.addAttribute("state",state);
        return "depot/out/insert";
    }

    //删除入库单
    @RequestMapping("/delete")
    public @ResponseBody
    int depot_out_delete(String id, String src){
        int result = depotOutService.delete(xmlPath,src,id);
        return result;
    }

    //审核
    @RequestMapping("/audit")
    public  @ResponseBody
    int depot_out_audit(String id,String src,String user){
        int result = depotOutService.audit(xmlPath,src,id,user);
        //System.out.println(result);
        return result;
    }

    //消审
    @RequestMapping("remove")
    public @ResponseBody
    int depot_out_remove(String id,String src){
        return depotOutService.remove(xmlPath,src,id);
    }

    //详情页查询
    @RequestMapping("detail_select")
    public @ResponseBody String[][] depot_out_detail_select(String out_no, String src){
        List result = depotOutService.detail_select(xmlPath,out_no,src);
        String[][] form = new String[result.size()][5];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("unit_name"));
            form[i][3]= String.valueOf(map.get("store_name"));
            form[i][4]= String.valueOf(map.get("ven_name"));
        }
        return form;
    }

    //详情页添加
    @RequestMapping("/detail_insert")
    public @ResponseBody int detail_insert(String out_no,String card_no,String src){
        return depotOutService.detail_insert(xmlPath,out_no,card_no,src);
        //System.out.println(out_no+card_no+src);
    }

    //详情页删除
    @RequestMapping("/detail_delete")
    public @ResponseBody int detail_delete(String id,String src){
        return depotOutService.detail_delete(xmlPath,id,src);
    }

    //详情页添加页面查询
    @RequestMapping("/detail_insert_select")
    public @ResponseBody
    String[][] depot_out_detail_insert_select(String out_no,String card_no, String src){
        //System.out.println(card_no+src);
        List result = depotOutService.detail_insert_select(xmlPath,out_no,card_no,src);
        String[][] form = new String[result.size()][4];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("ven_name"));
            form[i][3]= String.valueOf(map.get("store_name"));
        }
        return form;
    }

}
