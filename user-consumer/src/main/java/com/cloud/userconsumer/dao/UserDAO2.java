package com.cloud.userconsumer.dao;

import com.cloud.common.Gonggao;
import com.cloud.common.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
@Mapper
public interface UserDAO2 {
    // 用户分页查询
    @Select("SELECT * FROM user ORDER BY uaccount DESC")
    public List<User> selectUserWithPage();

    // 用户分页查询
    @Select("SELECT * FROM gonggao ORDER BY ggid DESC")
    public List<Gonggao> selectGonggaoWithPage();

}
