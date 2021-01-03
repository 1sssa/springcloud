package com.cloud.userconsumer.service;

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import com.github.pagehelper.PageInfo;



public interface UserService2 {

    // 分页查询文章列表
    public PageInfo<User> selectUserWithPage(Integer page4, Integer count);


    // 分页查询文章列表
    public PageInfo<Gonggao> selectGonggaoWithPage(Integer page5, Integer count);
}
