package com.cloud.newsprovider.controller;


import com.cloud.common.News;
import com.cloud.newsprovider.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 新闻Controller
 * 创建者：官晓敏
 */
@RestController
public class NewsController {
    @Autowired

    NewsDao newsDao;
    @RequestMapping(value = "/getAllnews",method = RequestMethod.GET)
    public List<News> getAllnews(){
        return newsDao.getAllnews();
    }

    @RequestMapping(value = "/getOnenews",method = RequestMethod.GET)
    public List<News> getOnenews(@RequestParam(value = "nkeyword")String nkeyword){
        return newsDao.getOnenews(nkeyword);
    }

    @RequestMapping(value = "/getOnenid",method = RequestMethod.GET)
    public News getOnenid(@RequestParam(value = "nid")int nid){
        return newsDao.getOnenid(nid);
    }

    //查询热度（阅读量）前十的新闻
    @RequestMapping(value = "/getToptennews",method = RequestMethod.GET)
    public List<News> getToptennews(){
        return newsDao.getToptennews();
    }

}
