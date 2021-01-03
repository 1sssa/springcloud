package com.cloud.userconsumer.service;


//import com.cloud.common.User;
//import com.cloud.userconsumer.hystrix.UserServiceHystrix;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
///**
// * @Classname LoginService
// * @Description TODO
// * @Date 2019-9-10 11:29
// * @Created by CrazyStone
// */
//@Component
//@FeignClient(value = "b2b-user-provider",fallback = UserServiceHystrix.class)
//public interface UserService {
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public User login(@RequestParam(value = "uname") String uname);
//
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public  int register(@RequestParam(value = "upassword") String upassword, @RequestParam(value = "uname") String uname, @RequestParam(value = "usex") String usex);
//}

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.cloud.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "b2b-user-provider",fallback = UserServiceHystrix.class)
public interface UserService {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam(value = "uname") String uname);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public  int register(@RequestParam(value = "uname") String uname,@RequestParam(value = "upassword") String upassword,  @RequestParam(value = "utype") String utype, @RequestParam(value = "uemail") String uemail);

    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public User findUser(@RequestParam(value = "uaccount") String uaccount);


    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int deleteUser(@RequestParam(value = "uaccount") String uaccount);

    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public  int updateUser(@RequestParam(value = "upassword") String upassword,@RequestParam(value = "uname") String uname, @RequestParam(value = "uemail") String uemail,@RequestParam(value = "utype") String utype,@RequestParam(value = "uaccount") String uaccount);


    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public  int addUser(@RequestParam(value = "uaccount") String uaccount,@RequestParam(value = "uname") String uname,@RequestParam(value = "upassword") String upassword,  @RequestParam(value = "utype") String utype, @RequestParam(value = "uemail") String uemail);






    @RequestMapping(value = "/findGonggao",method = RequestMethod.GET)
    public Gonggao findGonggao(@RequestParam("ggid") String ggid);

    @RequestMapping(value = "/deleteGonggao",method = RequestMethod.GET)
    public int deleteGonggao(@RequestParam("ggid") String ggid);


    @RequestMapping(value = "/updateGonggao",method = RequestMethod.GET)
    public int updateGonggao(@RequestParam(value = "gguname") String gguname,@RequestParam(value = "ggcontent") String ggcontent,@RequestParam(value = "ggtype") String ggtype,@RequestParam(value = "ggtime") String ggtime,@RequestParam(value ="ggid") String ggid);


    @RequestMapping(value = "/addGonggao",method = RequestMethod.GET)
    public int addGonggao(@RequestParam("ggid") String ggid, @RequestParam(value = "gguname") String gguname,@RequestParam(value = "ggcontent") String ggcontent,@RequestParam(value = "ggtype") String ggtype,@RequestParam(value = "ggtime") String ggtime);

}
