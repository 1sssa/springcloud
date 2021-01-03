package com.cloud.userprovider.dao;



//import com.cloud.common.User;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Component;
//
//@Mapper
//@Component
//public interface UserDao {
//    User login(@Param(value = "uname") String uname);//用户登录接口
//    int  register(@Param(value = "upassword") String upassword,
//                  @Param(value = "uname") String uname,
//                  @Param(value = "usex") String usex);//用户注册接口
//}
import com.cloud.common.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "UserDao")
public interface UserDao {
    //登录
    User login(@Param("uname") String uname);

    //用户注册接口
    int register(@Param(value = "uname") String uname,@Param(value = "upassword") String upassword,  @Param(value = "utype") String utype,@Param(value = "uemail") String uemail);

    //查找单个用户
    User findUser(@Param("uaccount") String uaccount);

    //删除用户
    int deleteUser(@Param("uaccount") String uaccount);

    //更新
    int updateUser(@Param(value = "upassword") String upassword,@Param(value = "uname") String uname,@Param(value = "uemail") String uemail,@Param(value = "utype") String utype,@Param("uaccount") String uaccount);


    //增加用户接口
    int addUser(@Param("uaccount") String uaccount,@Param(value = "uname") String uname,@Param(value = "upassword") String upassword,  @Param(value = "utype") String utype,@Param(value = "uemail") String uemail);


}
