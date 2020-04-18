package controller;

import entity.DepotDraw_insert;
import entity.DepotDraw_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepotDrawService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/depotDraw")
public class depotDrawController {
    @Autowired
    DepotDrawService depotDrawService;
    //引入的xml文件
    String xmlPath = "DepotDrawSQL.xml";

    //主页面查询
    @RequestMapping("/select")
    public String depot_draw_select(DepotDraw_select depotDraw_select, Model model){
        if (depotDraw_select.getDept().isEmpty()!=true){ depotDraw_select.setDept(depotDraw_select.getDept().substring(0,4)); }
        if (depotDraw_select.getStore().isEmpty()!=true){ depotDraw_select.setStore(depotDraw_select.getStore().substring(0,4)); }
        List result = depotDrawService.select(xmlPath,depotDraw_select);
        String[][] form = new String[result.size()][8];
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("draw_no"));
            form[i][1]= String.valueOf(map.get("dept_name"));
            form[i][2]= String.valueOf(map.get("store_name"));
            form[i][3]= String.valueOf(map.get("create_emp"));
            form[i][4]= String.valueOf(map.get("create_date").toString().substring(0,10));
            form[i][5]= String.valueOf(map.get("state"));
            form[i][6]= String.valueOf(map.get("audit_emp"));
            form[i][7]= String.valueOf(map.get("maker"));
        }
        model.addAttribute("result",form);
        return "depot/draw/main";
    }


    //添加领用单
    @RequestMapping("/insert")
    public String depot_draw_insert(DepotDraw_insert depotDraw_insert,Model model){
        if (depotDraw_insert.getStore().isEmpty()!=true){ depotDraw_insert.setStore(depotDraw_insert.getStore().substring(0,4)); }
        if (depotDraw_insert.getDept().isEmpty()!=true){ depotDraw_insert.setDept(depotDraw_insert.getDept().substring(0,4)); }
        String state = "添加失败！";
        int success= depotDrawService.insert(xmlPath,depotDraw_insert);
        if (success == 1){
            state = "添加成功！";
        }
//        System.out.println(depotInInsert.toString());
        model.addAttribute("state",state);
        return "depot/draw/insert";
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    int depot_draw_delete(String id, String src){
        return depotDrawService.delete(xmlPath,id,src);
    }

    //审核
    @RequestMapping("/audit")
    public @ResponseBody int depot_draw_audit(String id,String src,String user){
        return depotDrawService.audit(xmlPath,id,src,user);
    }

    //消审
    @RequestMapping("/remove")
    public @ResponseBody int depot_draw_remove(String id,String src){
        return depotDrawService.remove(xmlPath,id,src);
    }

    //详情页查询
    @RequestMapping("detail_select")
    public @ResponseBody String[][] depot_draw_detail_select(String draw_no, String src){
        List result = depotDrawService.detail_select(xmlPath,draw_no,src);
        //System.out.println(result.toString());
        String[][] form = new String[result.size()][5];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("unit"));
            form[i][3]= String.valueOf(map.get("store_name"));
            form[i][4]= String.valueOf(map.get("dept_name"));
        }
        //System.out.println(form[0][0]);
        return form;
    }

    //详情页添加
    @RequestMapping("/detail_insert")
    public @ResponseBody int depot_out_detail_insert(String draw_no,String card_no,String src){
        return depotDrawService.detail_insert(xmlPath,draw_no,card_no,src);
    }

    //详情页删除
    @RequestMapping("/detail_delete")
    public @ResponseBody int depot_draw_detail_delete(String id,String src){
        return depotDrawService.detail_delete(xmlPath,id,src);
    }

    //详情页添加页面查询
    @RequestMapping("/detail_insert_select")
    public @ResponseBody
    String[][] depot_draw_detail_insert_select(String draw_no,String card_no, String src){
        //System.out.println(card_no+src);
        List result = depotDrawService.detail_insert_select(xmlPath,draw_no,card_no,src);
        String[][] form = new String[result.size()][4];
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("vendor"));
            form[i][3]= String.valueOf(map.get("store"));
        }
        return form;
    }
}
