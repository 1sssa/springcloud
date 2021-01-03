package com.cloud.userconsumer.controller;

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.cloud.userconsumer.dao.UserDAO2;
import com.cloud.userconsumer.service.UserService2;
import com.cloud.userconsumer.service.implement.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController2 {
    @Autowired
    private UserService2 userService2;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserDAO2 userDAO2;




    //用户页
    @GetMapping(value = "/list4")
    public String user(HttpServletRequest request) {
        List<User> list4= userDAO2.selectUserWithPage();
        request.setAttribute("data4", list4);
        return this.user(request, 1, 5);
    }
    // 用户分页
    @GetMapping(value = "/page4/{p}")
    public String user(HttpServletRequest request, @PathVariable("p") int page4, @RequestParam(value = "count", defaultValue = "5") int count) {
        PageInfo<User> users = userService2.selectUserWithPage(page4, count);
        request.setAttribute("data4", users);
        return "admin/houtai2";
    }




    //公告页
    @GetMapping(value = "/list5")
    public String gonggao(HttpServletRequest request) {
        List<Gonggao> list5= userDAO2.selectGonggaoWithPage();
        request.setAttribute("data5", list5);
        return this.gonggao(request, 1, 5);
    }
    // 用户分页
    @GetMapping(value = "/page5/{p}")
    public String gonggao(HttpServletRequest request, @PathVariable("p") int page5, @RequestParam(value = "count", defaultValue = "5") int count) {
        PageInfo<Gonggao> gonggaos = userService2.selectGonggaoWithPage(page5, count);
        request.setAttribute("data5", gonggaos);
        return "admin/gonggao_list";
    }



}
