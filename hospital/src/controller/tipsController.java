package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TipsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping ("/tips")
public class tipsController {
    @Autowired
    TipsService tipsService;

    //引入的xml文件
    String xmlPath = "TipsSQL.xml";

    @RequestMapping ("/get_tips")
    public @ResponseBody List get_tips(String user, String src) throws SQLException {
        List result = tipsService.get_tips(xmlPath,src,user);
        return  result;
    }
}
