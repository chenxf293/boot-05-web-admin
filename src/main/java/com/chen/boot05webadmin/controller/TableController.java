package com.chen.boot05webadmin.controller;

import com.chen.boot05webadmin.bean.User;
import com.chen.boot05webadmin.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
//        //表格内容遍历
//        List<User> users = Arrays.asList(new User("zhangsan","sdhfshdf"),
//                new User("lisi","ahsdkh"),
//                new User("hha","jasjdalk"),
//                new User("hehe","jsldajl"));
//        model.addAttribute("users",users);
//
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        //从数据库中查出user表中的用户进行展示
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
