package com.work.virus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *  负责页面的跳转，登录注册等行为，在主页访问页面等
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        // 清空session
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/hotpot")
    public String hotpot(){
        return "hotpot";
    }
    @RequestMapping("/trend")
    public String trend(){
        return "trend";
    }

    @RequestMapping("/table_for_data")
    public String table_for_data(){
        return "table_for_data";
    }

}
