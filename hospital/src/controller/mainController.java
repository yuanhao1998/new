package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MainService;

import java.util.List;

@Controller
@RequestMapping("/main")
public class mainController {
    @Autowired
    MainService mainService;

    //引入的xml文件
    String xmlPath = "mainSQL.xml";

    @RequestMapping("/auto_number1")
    public @ResponseBody
    Integer get_auto_number1(String src){
        Integer result = mainService.get_auto_number(xmlPath,src);
        if (result == null){
            result = 10010001;
        }
        else {
            result += 1;
        }
        return result;
    }
    @RequestMapping("/auto_number2")
    public @ResponseBody
    Integer get_auto_number2(String src){
        Integer result = mainService.get_auto_number(xmlPath,src);
        if (result == null){
            result = 1001;
        }
        else {
            result += 1;
        }
        return result;
    }

    @RequestMapping("/get_option")
    public @ResponseBody
    List get_option(String value,String src){
        List result = mainService.get_option(xmlPath,value,src);
        System.out.println(result.toString());
//        System.out.println(value+src);
        return result;
    }
}
