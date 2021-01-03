package com.cloud.newsconsumer.service;


import com.cloud.common.Comment;
import com.cloud.common.News;
import com.cloud.newsconsumer.hystrix.NewsServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Component
///////
@FeignClient(value="b2b-news-provider",fallback =
        NewsServiceHystrix.class)
public interface NewsService {
    @RequestMapping(value = "/getAllnews",method = RequestMethod.GET)
    public List<News> getAllnews();

    @RequestMapping(value = "/getOnenews",method = RequestMethod.GET)
    public List<News> getOnenews(@RequestParam(value = "nkeyword") String nkeyword);

    @RequestMapping(value = "/getOnenid",method = RequestMethod.GET)
    public News getOnenid(@RequestParam(value = "nid") int nid);

    //查询热度（阅读量）前十的新闻
    @RequestMapping(value = "/getToptennews",method = RequestMethod.GET)
    public List<News> getToptennews();


    //插入评论
    //@RequestMapping(value = "/intsertcomment",method = RequestMethod.POST)
    @RequestMapping(value = "/intsertcomment",method = RequestMethod.GET)
    public int intsertcomment(@RequestParam(value = "ccontext") String ccontext, @RequestParam(value = "cusername") String cusername, @RequestParam(value = "ctime") String ctime, @RequestParam(value = "cuser_img") String cuser_img);
    //void intsertcomment(Comment comment);

    // 查询全部评论
    @RequestMapping(value = "/getAllcomment",method = RequestMethod.GET)
    //public List<Comment> getAllcomment(@RequestParam(value = "cid") int cid);
    public List<Comment> getAllcomment();


}

