package controller;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SettingService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/setting")
public class settingController {
    @Autowired
    SettingService settingService;

    //引入的xml文件
    String xmlPath = "SettingSQL.xml";

    @RequestMapping("/vendor_select")
    public String vendor_select(String ven_name,String ven_code,String ven_type,String src, Model model){
        List result = settingService.vendor_select(xmlPath,ven_name,ven_code,ven_type,src);
//        System.out.println(vendor_select.toString());
//        System.out.println(result.toString());
        int z = result.size();
        String[][] form = new String[z][3];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("ven_code"));
            form[i][1]= String.valueOf(map.get("ven_name"));
            form[i][2]= String.valueOf(map.get("ven_type_name"));
        }
        model.addAttribute("result",form);
        return "setting/vendor";
    }

    @RequestMapping("/vendor_insert")
    public String vendor_insert(Vendor_insert vendor_insert,Model model){
        if (vendor_insert.getVen_type().isEmpty()!=true){
            vendor_insert.setVen_type(vendor_insert.getVen_type().substring(0,4));
        }
        String success = String.valueOf(settingService.vendor_insert(xmlPath,vendor_insert));
        //System.out.println(success);
        String state = "添加失败！";
        if (success != null){
            state = "添加成功！";
        }
//        System.out.println(depotInInsert.toString());
        model.addAttribute("state",state);
        return "setting/vendor_insert";
    }

    @RequestMapping("/vendor_delete")
    public @ResponseBody
    int vendor_delete(String id, String src){
        int success = settingService.vendor_delete(xmlPath,id,src);
        return success;
    }

    @RequestMapping("/load_ven_detail")
    public @ResponseBody List ven_detail_select(String id,String src){
        //System.out.println(id);
        List result = settingService.vendor_detail_select(xmlPath,src,id);
        //System.out.println(result.toString());
        return result;
    }

    @RequestMapping("/vendor_detail_update")
    public String ven_detail_update(Vendor_detail_update vendor_detail_update,Model model){
        String state = "修改失败！";
        if (vendor_detail_update.getIs_stop() == null){
            vendor_detail_update.setIs_stop("0");
        }
        else if (vendor_detail_update.getIs_stop().equals("on")){
            vendor_detail_update.setIs_stop("1");
        }
        String success = settingService.vendor_detail_update(xmlPath,vendor_detail_update);
        //System.out.println(vendor_detail_update.toString()+success);
        if (success.equals("1")){
            state = "修改成功！";
        }
        model.addAttribute("state",state);
        return "setting/vendor_detail";
    }

    @RequestMapping("/dept_select")
    public String dept_select(String dept_code,String dept_name,String src,Model model){
        List result = settingService.dept_select(xmlPath,dept_code,dept_name,src);
        //System.out.println(result.toString());
        String[][] form = new String[result.size()][3];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("dept_code"));
            form[i][1]= String.valueOf(map.get("dept_name"));
            form[i][2]= String.valueOf(map.get("is_stop"));
        }
        model.addAttribute("result",form);
        return "setting/dept";
    }

    @RequestMapping("/dept_insert")
    public String dept_insert(Dept_insert dept_insert,Model model){
        //System.out.println(dept_insert.toString());
        String success = settingService.dept_insert(xmlPath,dept_insert);
        String state = "添加失败";
        if (success.equals("1")){
            state = "添加成功！";
        }
        model.addAttribute("state",state);
        return "setting/dept_insert";
    }

    @RequestMapping("/dept_delete")
    public @ResponseBody int dept_delete(String id,String src){
        //System.out.println(id+src);
        int state = settingService.dept_delete(xmlPath,src,id);
        return state;
    }

    @RequestMapping("/dept_update_state")
    public @ResponseBody int  dept_update_state(String id){
        Integer state = settingService.dept_select_state(id);
        System.out.println(state);
        if (state == 0){ state = 1; }
        else { state = 0; }
        System.out.println(state);
        return settingService.dept_update_state(id,state);
    }

    @RequestMapping("/equi_select")
    public String equi_select(String equi_code,String equi_name,String equi_type,String src, Model model){
        if (equi_type.isEmpty()!=true){
            equi_type=equi_type.substring(0,4);
        }
        List result = settingService.equi_select(xmlPath,equi_code,equi_name,equi_type,src);
        //System.out.println(equi_select.toString()+result.toString());
        String[][] form = new String[result.size()][6];
        //将查询到的数据赋给二维数组
        for (int i=0;i<result.size();i++){
            Map map = (Map) result.get(i);
            form[i][0]= String.valueOf(map.get("equi_code"));
            form[i][1]= String.valueOf(map.get("equi_name"));
            form[i][2]= String.valueOf(map.get("equi_type_name"));
            form[i][3]= String.valueOf(map.get("unit_name"));
            form[i][4]= String.valueOf(map.get("equi_model"));
            form[i][5]= String.valueOf(map.get("is_stop"));
        }
        model.addAttribute("result",form);
        return "setting/equi";
    }

    @RequestMapping("/equi_insert")
    public String  equi_insert(Equi_insert equi_insert,Model model){
        if (equi_insert.getEqui_type().isEmpty()!=true){
            equi_insert.setEqui_type(equi_insert.getEqui_type().substring(0,4));
        }
        if (equi_insert.getUnit().isEmpty()!=true){
            equi_insert.setUnit(equi_insert.getUnit().substring(0,4));
        }
        String success = String.valueOf(settingService.equi_insert(xmlPath,equi_insert));
        String state = "添加失败";
        if (success.equals("1")){
            state = "添加成功！";
        }
        model.addAttribute("state",state);
        return "setting/equi_insert";
    }

    @RequestMapping("/equi_delete")
    public @ResponseBody int equi_delete(String id,String src){
        return settingService.equi_delete(xmlPath,id,src);
    }

    @RequestMapping("/equi_update_state")
    public @ResponseBody int  equi_update_state(String id){
        Integer state = settingService.equi_select_state(id);
        System.out.println(state);
        if (state == 0){ state = 1; }
        else { state = 0; }
        System.out.println(state);
        return settingService.equi_update_state(id,state);
    }
}
