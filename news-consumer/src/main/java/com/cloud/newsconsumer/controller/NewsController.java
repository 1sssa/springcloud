package com.cloud.newsconsumer.controller;



import com.cloud.common.Comment;
import com.cloud.common.News;
import com.cloud.newsconsumer.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    //退出登录并跳转回登录页面
    @GetMapping(value = "quit")
    public String quit(HttpSession session) {
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/tologin";
    }


    //首页查询全部新闻
    @GetMapping(value = "/getAllxinwen")
    public String getAllxinwen(HttpServletRequest request, String uname,  HttpSession session) {
        session.setAttribute("uname", uname);
        List<News> news1 = new ArrayList<>();
    /*        List<News> news2 = new ArrayList<>();
            List<News> news3 = new ArrayList<>();
            List<News> news4 = new ArrayList<>();*/
        List<News> oldnews = newsService.getAllnews();
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(1)) {
                news1.add(newnews);
            }
/*            if (newnews.getNtypes().equals(2)) {
                news2.add(newnews);
            }
            if (newnews.getNtypes().equals(0)) {
                news3.add(newnews);
            }
            if (newnews.getNtypes().equals(3)) {
                news4.add(newnews);
            }*/
        }
        request.setAttribute("news1", news1);
/*        request.setAttribute("news2", news2);
        request.setAttribute("news3", news3);
        request.setAttribute("news4", news4);*/
        return "qiantai/index";
    }


    //查询全部国内新闻
    @GetMapping(value = "/getAllguonei")
    public String getAllguonei(HttpServletRequest request, String uaccount,
                               String upasswoed, String uname, String usex, HttpSession session) {
        //session.setAttribute("uaccount", uaccount);
        List<News> news2 = new ArrayList<>();
        List<News> oldnews = newsService.getAllnews();
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(2)) {
                news2.add(newnews);
            }
        }
        request.setAttribute("news2", news2);
        return "/qiantai/guonei";
    }


    //查询全部国际新闻
    @GetMapping(value = "/getAllguoji")
    public String getAllguoji(HttpServletRequest request, String uaccount,
                              String upasswoed, String uname, String usex, HttpSession session) {
        //session.setAttribute("uaccount", uaccount);

        List<News> news3 = new ArrayList<>();

        List<News> oldnews = newsService.getAllnews();
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(3)) {
                news3.add(newnews);
            }
        }
        request.setAttribute("news3", news3);
        return "/qiantai/guoji";
    }


    //查询全部科技新闻
    @GetMapping(value = "/getAllkeji")
    public String getAllkeji(HttpServletRequest request, String uaccount,
                             String upasswoed, String uname, String usex, HttpSession session) {
        //session.setAttribute("uaccount", uaccount);

        List<News> news4 = new ArrayList<>();

        List<News> oldnews = newsService.getAllnews();
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(4)) {
                news4.add(newnews);
            }
        }
        request.setAttribute("news4", news4);
        return "/qiantai/keji";
    }






    //新闻首页搜索-根据关键词模糊查找新闻
    @GetMapping(value = "/getOne")
    public String getOne(HttpServletRequest request, String keyword) {
        List<News> news1 = new ArrayList<>();
        List<News> news2 = new ArrayList<>();
        List<News> news3 = new ArrayList<>();
        List<News> news4 = new ArrayList<>();
        List<News> oldnews = newsService.getOnenews(keyword);//keyword对应搜索框里的name="keyword"
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(1) || newnews.getNtypes().equals(2) || newnews.getNtypes().equals(3) || newnews.getNtypes().equals(4)) {
                news1.add(newnews);
            }
            if (newnews.getNtypes().equals(2)) {
                news2.add(newnews);
            }
            if (newnews.getNtypes().equals(3)) {
                news3.add(newnews);
            }
            if (newnews.getNtypes().equals(4)) {
                news4.add(newnews);
            }
        }
        request.setAttribute("news1", news1);
        request.setAttribute("news2", news2);
        request.setAttribute("news3", news3);
        request.setAttribute("news4", news4);
        return "/qiantai/search";
    }

    //显示热度（阅读量）前10篇新闻
    @GetMapping(value = "/getTophot")
    public String getTophot(HttpServletRequest request, String uaccount,
                            String upasswoed, String uname, String usex, HttpSession session) {
        //session.setAttribute("uaccount", uaccount);
        List<News> news1 = new ArrayList<>();
        List<News> oldnews = newsService.getToptennews();
        for (News newnews : oldnews) {
            System.out.print(newnews.getNtypes());
            if (newnews.getNtypes().equals(1)|| newnews.getNtypes().equals(2) || newnews.getNtypes().equals(3) || newnews.getNtypes().equals(4)) {
                news1.add(newnews);
            }
        }
        request.setAttribute("news1", news1);

        return "/qiantai/hot";
    }



    //新闻详情-即根据ID查询单条新闻
    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request, int nid , Integer cid,Model model) {
        request.setAttribute("detail", newsService.getOnenid(nid));
        // 查询全部评论
        List<Comment> comment = newsService.getAllcomment();
        model.addAttribute("comment",comment);
        //request.setAttribute("commet",newsService.getAllcomment());
        return "/qiantai/detail";
    }



    //插入评论

    @GetMapping(value = "intsertcomment")
    public  String intsertcomment(HttpServletRequest request,HttpSession session,String uname,String ccontext,String cusername,String ctime,String cuser_img){
        //session.setAttribute("uname", uname);
        newsService.intsertcomment(ccontext,cusername,ctime,cuser_img);
        //return "detail";
        return "redirect:/news/getAllguonei";
    }


}