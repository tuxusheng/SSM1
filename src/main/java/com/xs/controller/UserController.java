package com.xs.controller;

import com.xs.pojo.User;
import com.xs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    //自动注入UserService
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        user = userService.get(user);
        System.out.println("login..........");
        if (user != null) {
            //数据库检查
            session.setAttribute("SESSION_USER", user);
            return "user";
        } else {
            return "redirect:/login.jsp";
        }

    }

    @RequestMapping("/m1")
    public String m1() {
        System.out.println("asdfsadfsa");
        return "login";
    }
}
