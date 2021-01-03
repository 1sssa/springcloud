package com.cloud.newsprovider.dao;

import com.cloud.common.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "CommentDao")///
@Mapper
public interface CommentDao {

    //查询所有评论
    List<Comment> getAllcomment();
    //List<Comment> getAllcomment(@Param(value = "cid") int cid);

    //插入一条评论
    int intsertcomment(@Param(value = "ccontext") String ccontext, @Param(value
            = "cusername") String cusername, @Param(value = "ctime") String ctime, @Param(value
            = "cuser_img") String cuser_img);
    //void intsertcomment(Comment comment);
}
