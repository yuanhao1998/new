package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

import java.sql.SQLException;


@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(String name,String password, Model model) throws SQLException {

        boolean success = userService.login(name,password);
        if (success){
            model.addAttribute("user",name);
            return "login/top";
        }
        else {
            model.addAttribute("error","账户或密码错误！");
            return "login/login";
        }

    }
}
