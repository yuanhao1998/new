package controller;

import entity.EquiScrap_insert;
import entity.EquiScrap_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.EquiScrapService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Scrap")
public class equiScrapController {
    @Autowired
    EquiScrapService equiScrapService;

    //引入的xml文件
    String xmlPath = "EquiScrapSQL.xml";

    //查询
    @RequestMapping("/select")
    public String equi_scrap_select(EquiScrap_select equiScrap_select, Model  model){
        List result = equiScrapService.select(xmlPath,equiScrap_select);
        //System.out.println(result.toString());
        //将list转为二维数组
        String[][] form = new String[result.size()][6];
        //System.out.println(result.toString());
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++) {
            Map map = (Map) result.get(i);
            form[i][0] = String.valueOf(map.get("scrap_no"));
            form[i][1] = String.valueOf(map.get("create_emp"));
            form[i][2] = String.valueOf(map.get("create_date").toString().substring(0, 10));
            form[i][3] = String.valueOf(map.get("state"));
            form[i][4] = String.valueOf(map.get("audit_emp"));
            form[i][5] = String.valueOf(map.get("maker"));
        }
        model.addAttribute("result",form);
        return "scrap/main";
    }

    //添加
    @RequestMapping("/insert")
    public String scrap_insert(EquiScrap_insert equiScrap_insert,Model model){
        int success = equiScrapService.insert(xmlPath,equiScrap_insert);
        String state = "添加失败！";
        if (success == 1){
            state = "添加成功！";
        }
        model.addAttribute("state",state);
        return "scrap/insert";
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody int scrap_delete(String id,String src){
        return equiScrapService.delete(xmlPath,id,src);
    }

    //审核
    @RequestMapping("/audit") public  @ResponseBody int audit(String id,String src,String user){
        int result = equiScrapService.audit(xmlPath,src,id,user);
        //System.out.println(result);
        return result;
    }
    //消审
    @RequestMapping("remove")
    public @ResponseBody
    int remove(String id,String src){
        return equiScrapService.remove(xmlPath,src,id);
    }

    //详情页查询
    @RequestMapping("detail_select")
    public @ResponseBody String[][] depot_out_detail_select(String scrap_no, String src){
        List result = equiScrapService.detail_select(xmlPath,scrap_no,src);
        //System.out.println(result.toString());
        String[][] form = new String[result.size()][5];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("unit"));
            form[i][3]= String.valueOf(map.get("store"));
            form[i][4]= String.valueOf(map.get("ven_name"));
        }
        //System.out.println(form[0][0]);
        return form;
    }

    //详情页添加
    @RequestMapping("/detail_insert")
    public @ResponseBody int scrap_detail_insert(String scrap_no,String card_no,String src){
        return equiScrapService.detail_insert(xmlPath,scrap_no,card_no,src);
        //System.out.println(out_no+card_no+src);
    }

    //详情页删除
    @RequestMapping("/detail_delete")
    public @ResponseBody int depot_out_detail_delete(String id,String src){
        return equiScrapService.detail_delete(xmlPath,id,src);
    }

    //详情页添加页面查询
    @RequestMapping("/detail_insert_select")
    public @ResponseBody String[][] scrap_detail_insert_select(String scrap_no,String card_no, String src){
        List result = equiScrapService.detail_insert_select(xmlPath,scrap_no,card_no,src);
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
