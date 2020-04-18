package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ListSelectService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/List")
public class listSelectController {
    @Autowired
    ListSelectService listSelectService;

    //引入的xml文件
    String xmlPath = "ListSelectSQL.xml";

    @RequestMapping("/equi_month_select")
    public @ResponseBody
    String[][] equi_month_select(String month, String store, String src){
        if (store.isEmpty()!=true){
            store=store.substring(0,4);
        }
        List result=listSelectService.equi_month_select(xmlPath,month,store,src);
        //将list转为二维数组
        String[][] form = new String[result.size()][3];
        //System.out.println(result.toString());
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("in_money"));
            form[i][1]= String.valueOf(map.get("out_money"));
            form[i][2]= String.valueOf(map.get("draw_money"));
        }
        return form;
    }

    @RequestMapping("/equi_in_detail")
    public @ResponseBody
    String[][] equi_in_detail(String month, String store, String src){
        if (store.isEmpty()!=true){
            store=store.substring(0,4);
        }
        List result=listSelectService.equi_in_detail(xmlPath,month,store,src);
        //将list转为二维数组
        String[][] form = new String[result.size()][7];
        System.out.println(result.toString());
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("in_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("price"));
            form[i][3]= String.valueOf(map.get("prin_emp"));
            form[i][4]= String.valueOf(map.get("ven_name"));
            form[i][5]= String.valueOf(map.get("state"));
            form[i][6]= String.valueOf(map.get("in_date"));
        }
        return form;
    }

    @RequestMapping("/dept_draw_list")
    public @ResponseBody
    String[][] dept_draw_list(String month, String store, String src){
        if (store.isEmpty()!=true){
            store=store.substring(0,4);
        }
        List result=listSelectService.dept_draw_list(xmlPath,month,store,src);
        //将list转为二维数组
       String[][] form = new String[result.size()][6];
        //System.out.println(result.toString());
       //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("draw_no"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("store_name"));
            form[i][3]= String.valueOf(map.get("dept_name"));
            form[i][4]= String.valueOf(map.get("draw_date"));
            form[i][5]= String.valueOf(map.get("create_emp"));
        }
        return form;
    }
}
