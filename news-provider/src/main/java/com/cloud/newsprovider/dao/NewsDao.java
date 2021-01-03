package com.cloud.newsprovider.dao;


import com.cloud.common.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 新闻查询
 * 创建者：官晓敏
 */
@Component(value = "NewsDao")///
@Mapper

public interface NewsDao {

    //查询所有新闻
    List<News> getAllnews();

    //根据新闻关键词模糊查找
    List<News> getOnenews(@Param(value = "nkeyword") String nkeyword);

    //根据id查询单条新闻详情
    News getOnenid(@Param(value = "nid") int nid);

    //查询热度（阅读量）前十的新闻
    //News getToptennews(@Param(value = "nhot") int nhot);
    List<News> getToptennews();
}
