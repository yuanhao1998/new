package controller;

import entity.EquiSelect_select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.EquiSelectService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equiSelect")
public class equiSelectController {
    @Autowired
    EquiSelectService equiSelectService;

    //引入的xml文件
    String xmlPath = "EquiSelectSQL.xml";

    @RequestMapping("/select")
    public String equiSelect_select(EquiSelect_select equiSelect_select, Model model){
        List result = equiSelectService.equiSelect_select(xmlPath,equiSelect_select);
        //System.out.println(result.toString());
        String[][] form = new String[result.size()][8];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("card_no"));
            form[i][1]= String.valueOf(map.get("equi_code"));
            form[i][2]= String.valueOf(map.get("equi_name"));
            form[i][3]= String.valueOf(map.get("ven_name"));
            form[i][4]= String.valueOf(map.get("store_name"));
            form[i][5]= String.valueOf(map.get("in_date").toString().substring(0,10));
            form[i][6]= String.valueOf(map.get("prin_emp"));
            form[i][7]= String.valueOf(map.get("state"));
        }
        model.addAttribute("result",form);
        return "select/main";
    }
}
