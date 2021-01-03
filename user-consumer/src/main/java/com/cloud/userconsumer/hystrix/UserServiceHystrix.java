package com.cloud.userconsumer.hystrix;

//import com.cloud.common.User;
//import com.cloud.userconsumer.service.UserService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserServiceHystrix implements UserService {
//    @Override
//    public User login(String uaccount) {
//        return null;
//    }
//
//    @Override
//    public int register(String upassword, String uname, String usex) {
//        return 0;
//    }
//}

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.cloud.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {


    @Override
    public User login(String uname) {
        return null;
    }

    @Override
    public int register(String uname, String upassword, String utype, String uemail) {
        return 0;
    }

    @Override
    public User findUser(String uaccount) {
        return null;
    }

    @Override
    public int deleteUser(String uaccount) {
        return 0;
    }

    @Override
    public int updateUser(String upassword, String uname, String uemail, String utype, String uaccount) {
        return 0;
    }

    @Override
    public int addUser(String uaccount, String uname, String upassword, String utype, String uemail) {
        return 0;
    }

    @Override
    public Gonggao findGonggao(String ggid) {
        return null;
    }

    @Override
    public int deleteGonggao(String ggid) {
        return 0;
    }

    @Override
    public int updateGonggao(String gguname, String ggcontent, String ggtype, String ggtime, String ggid) {
        return 0;
    }

    @Override
    public int addGonggao(String ggid, String gguname, String ggcontent, String ggtype, String ggtime) {
        return 0;
    }
}
