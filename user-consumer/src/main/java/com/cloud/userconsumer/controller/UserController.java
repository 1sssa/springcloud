package com.cloud.userconsumer.controller;


//import com.cloud.userconsumer.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/admin")
//public class UserController {
//    @Autowired
//    UserService userService;
//     //跳转登录界面
//    @GetMapping(value = "/tologin")
//    public String tologin() {
//        return "login";
//    }
//     // 跳转注册界面
//    @GetMapping(value = "/toregister")
//    public String toregister() {
//        return "register";
//    }
//     // 用户登录
//    @GetMapping(value = "/login")
//    public String login(String uname, String upassword, String uimgs,HttpServletRequest request) {
//       if (userService.login(uname) != null) {
//            if (userService.login(uname).getUpassword().equals(upassword)){
//                HttpSession session = request.getSession(true);
//                session.setAttribute("user", userService.login(uname));  //将登陆者信息存入session
//                //session.setAttribute("user", userService.login(uimgs));  //将登陆者头像存入session
//              //return "redirect:http://localhost:8896/news/getAllxinwen?uaccount="+userService.login(uname).getUaccount()+"&upasswoed="+userService.login(uname).getUpassword();
//              return "redirect:http://localhost:8896/news/getAllxinwen?uname="+userService.login(uname).getUname()+"&upasswoed="+userService.login(uname).getUpassword();
//            }
//        }
//       // request.setAttribute("mag","账号密码错误");
//        System.out.print("登录成功");
//        return "login";
//    }
//    //用户注册
//    @GetMapping(value = "/register")
//    public String register(HttpServletRequest request,String upassword,String uname,String usex) {
//       if(userService.register(upassword, uname, usex)>0){
//           System.out.print("注册成功");
//           return "login";
//       }
//        System.out.print("注册失败");
//        return "register";
//    }
//}
import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.cloud.userconsumer.service.UserService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //跳转登录界面
    @GetMapping(value = "/tologin")
    public String tologin() {
        return "admin/login";
    }
    // 跳转注册界面
    @GetMapping(value = "/toregister")
    public String toregister() {
        return "admin/register";
    }

    @GetMapping(value = "/toAdd")
    public String toAdd() {
        return "admin/user_add";
    }


    @GetMapping(value = "/login")
    public String login(String uname, String upassword,String utype, HttpServletRequest request) {
        if (userService.login(uname) != null) {
            if ((userService.login(uname).getUpassword().equals(upassword)) && (userService.login(uname).getUtype().equals(utype))){
                if(utype.equals("管理员")){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", userService.login(uname));  //将登陆者信息存入session
                    System.out.println("管理员登录");
                    return "redirect:/list4";   //跳转到查询用户所有
//                    return "admin/test";   //跳转到查询用户所有
                }else{
                    if(utype.equals("用户")){
                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", userService.login(uname));  //将登陆者信息存入session
                        System.out.println("用户登录");
//                        return "admin/test";
                        return "redirect:http://localhost:8896/news/getAllxinwen?uname="+userService.login(uname).getUname()+"&upasswoed="+userService.login(uname).getUpassword();
                    }
                    else {
                        System.out.println("登录失败");
                        return "admin/test2";
                    }
                }
            }
        }
        // request.setAttribute("mag","账号密码错误");
        System.out.print("登录失败");
        return "admin/login";
    }





    //用户注册
    @GetMapping(value = "/register")
    public String register (HttpServletRequest request, String upassword, String uname, String utype, String uemail)
    {
        if (userService.register(uname, upassword, utype, uemail) >0) {
            System.out.print("注册成功");
            return "admin/login";
        }
        System.out.print("注册失败");
        return "admin/register";
    }



    //通过id查询某个用户
    @GetMapping(value = "/findUser")
    public String findUser(String uaccount,Model model){

//        request.setAttribute("findUser", userService.findUser(account));
        User user = userService.findUser(uaccount);
        model.addAttribute("user",user);
        return "admin/user_update";    //跳到updateEmp页面
    }



    //    删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(String id){
        userService.deleteUser(id);
        return "redirect:/list4";   //删除成功后成功后返回list4
    }


    //更新用户
    @PostMapping("/updateUser")
    public String updateUser(String upassword,String uname,String uemail,String utype,String uaccount) {
        userService.updateUser(upassword,uname,uemail,utype,uaccount);
        return "redirect:/list4";
    }


    //增加用户
    @PostMapping("/addUser")
    public String addUser(String uaccount,String upassword, String uname, String utype, String uemail){
        userService.addUser(uaccount,uname, upassword, utype, uemail);
        return "redirect:/list4";    //增加成功后返回list4
    }



    @GetMapping(value = "/toAddGonggao")
    public String toAddGonggao() {
        return "admin/gonggao_add";
    }





    //通过id查询某个公告
    @GetMapping(value = "/findGonggao")
    public String findGonggao(String ggid, Model model){
        Gonggao gonggao = userService.findGonggao(ggid);
        model.addAttribute("gonggao",gonggao);
        return "admin/gonggao_update";
    }



    //    删除公告
    @GetMapping("/deleteGonggao")
    public String deleteGonggao(String ggid){
        userService.deleteGonggao(ggid);
        return "redirect:/list5";
    }


    //更新公告
    @PostMapping("/updateGonggao")
    public String updateGonggao(String gguname,String ggcontent,String ggtype,String ggtime,String ggid) {
        userService.updateGonggao(gguname,ggcontent,ggtype,ggtime,ggid);
        return "redirect:/list5";
    }


    //增加公告
    @PostMapping("/addGonggao")
    public String addGonggao(String ggid,String gguname, String ggcontent, String ggtype, String ggtime){
        userService.addGonggao(ggid,gguname,ggcontent,ggtype,ggtime);
        return "redirect:/list5";
    }


}