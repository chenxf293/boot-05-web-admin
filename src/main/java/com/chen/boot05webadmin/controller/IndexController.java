package com.chen.boot05webadmin.controller;

import com.chen.boot05webadmin.bean.City;
import com.chen.boot05webadmin.bean.KikuchuPage;
import com.chen.boot05webadmin.bean.User;
import com.chen.boot05webadmin.service.CityService;
import com.chen.boot05webadmin.service.KikuchuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    KikuchuService kikuchuService;
    @Autowired
    CityService cityService;
    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }
    @ResponseBody
    @GetMapping("kikuchu")
    public KikuchuPage getById(@RequestParam("id") Integer id){

        return kikuchuService.getKikuchuPageById(id);
    }
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long along = jdbcTemplate.queryForObject("select count(*) from sample_db.kikuchu_page",Long.class);
        return along.toString();
    }
    @GetMapping(value = {"/","login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html; 重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model modle){

        return "main";

    }
}
