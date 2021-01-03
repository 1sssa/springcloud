package com.cloud.newsconsumer.hystrix;


import com.cloud.common.Comment;
import com.cloud.common.News;
import com.cloud.newsconsumer.service.NewsService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NewsServiceHystrix implements NewsService {

    @Override
    public List<News> getAllnews() {
        return null;
    }

    @Override
    public List<News> getOnenews(String nkeyword) {
        return null;
    }

    @Override
    public News getOnenid(int nid) {
        return null;
    }

    @Override
    public List<News> getToptennews() {
        return null;
    }

//    @Override
//    public void intsertcomment(Comment comment) {
//
//    }


    @Override
    public int intsertcomment(String ccontext, String cusername, String ctime, String cuser_img) {
        return 0;
    }

    @Override
    //public List<Comment> getAllcomment(int cid) {
    public List<Comment> getAllcomment() {
        return null;
    }


}
