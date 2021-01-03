package com.cloud.userconsumer.service.implement;

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.cloud.userconsumer.dao.UserDAO2;
import com.cloud.userconsumer.service.UserService2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService2 {

    //注入userDAO对象
    @Autowired(required = false)
    private UserDAO2 userDAO2;


    // 分页查询文章列表
    @Override
    public PageInfo<User> selectUserWithPage(Integer page4, Integer count) {
        PageHelper.startPage(page4, count);
        List<User> userList = userDAO2.selectUserWithPage();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }



    // 分页查询文章列表
    @Override
    public PageInfo<Gonggao> selectGonggaoWithPage(Integer page5, Integer count) {
        PageHelper.startPage(page5, count);
        List<Gonggao> gonggaoList = userDAO2.selectGonggaoWithPage();
        PageInfo<Gonggao> pageInfo=new PageInfo<>(gonggaoList);
        return pageInfo;
    }









}
