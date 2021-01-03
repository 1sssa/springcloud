package com.cloud.newsprovider.controller;


import com.cloud.common.Comment;
import com.cloud.newsprovider.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentDao commentDao;

//    //查找所有评论
    @RequestMapping(value = "/getAllcomment",method = RequestMethod.GET)
    public List<Comment> getAllcomment(){
    //public List<Comment> getAllcomment(@RequestParam(value = "cid")int cid){
        //return commentDao.getAllcomment(cid);
        return commentDao.getAllcomment();
    }



    //插入评论
   //@RequestMapping(value = "/intsertcomment",method = RequestMethod.POST)///GET
   @RequestMapping(value = "/intsertcomment",method = RequestMethod.GET)///GET
    public int intsertcomment(@RequestParam(value = "ccontext")String ccontext, @RequestParam(value = "cusername")String cusername,
                       @RequestParam(value = "ctime")String ctime,@RequestParam(value =
            "cuser_img")String cuser_img){
        return commentDao.intsertcomment(ccontext,cusername,ctime,cuser_img);
    }


//    public void intsertcomment(Comment comment) {
//        commentDao.intsertcomment(comment);
//    }
}
