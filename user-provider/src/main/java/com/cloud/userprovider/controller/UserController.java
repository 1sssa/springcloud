package com.cloud.userprovider.controller;


//import com.cloud.common.User;
//import com.cloud.userprovider.dao.UserDao;
//import org.checkerframework.checker.units.qual.A;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    UserDao userDao;
//
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public User login(@RequestParam("uname") String uname){
//        return userDao.login(uname);
//    }
//
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public int register(@RequestParam(value = "upassword")String upassword,
//                        @RequestParam(value = "uname")String uname,
//                        @RequestParam(value = "usex") String usex){
//        return userDao.register(upassword,uname,usex);
//    }
//}

import com.cloud.common.User;
import com.cloud.userprovider.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserDao userDao;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@Param("uname") String uname){
        return userDao.login(uname);
    }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "uname") String uname,@RequestParam(value = "upassword") String upassword, @RequestParam(value = "utype") String utype,@RequestParam(value = "uemail") String uemail){
        return userDao.register(uname,upassword,utype,uemail);
    }


    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public User findUser(@Param("uaccount") String uaccount){
        return userDao.findUser(uaccount);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int deleteUser(@Param("uaccount") String uaccount){
        return userDao.deleteUser(uaccount);
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public int updateUser(@Param(value = "upassword") String upassword,@Param(value = "uname") String uname,@Param(value = "uemail") String uemail,@Param(value = "utype") String utype,@Param("uaccount") String uaccount){
        return userDao.updateUser(upassword,uname,uemail,utype,uaccount);
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public int addUser(@Param("uaccount") String uaccount,@RequestParam(value = "uname") String uname,@RequestParam(value = "upassword") String upassword, @RequestParam(value = "utype") String utype,@RequestParam(value = "uemail") String uemail){
        return userDao.addUser(uaccount,uname,upassword,utype,uemail);
    }





}
