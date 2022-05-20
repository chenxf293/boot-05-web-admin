package com.chen.boot05webadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.boot05webadmin.bean.User;
import com.chen.boot05webadmin.exception.UserTooManyException;
import com.chen.boot05webadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;
    @GetMapping("/basic_table")
    public String basic_table(){
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
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
        List<User> list = userService.list();
//        model.addAttribute("users",list);
        //分页查询数据
        //数据查询结果
        Page<User> userPage = new Page<>(pn,2);
        Page<User> page = userService.page(userPage,null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total =page.getTotal();
        List<User> records = page.getRecords();
        model.addAttribute("page",page);
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