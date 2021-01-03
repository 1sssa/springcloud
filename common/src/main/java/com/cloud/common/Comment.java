package com.cloud.common;

public class Comment {

    public int cid;          //评论id
    public int article_id;    //评论的新闻id
    public String ccontext;  //评论内容
    public String cusername;  //评论的用户名
    public String ctime;     //评论日期
    public String cuser_img;  //头像

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getCcontext() {
        return ccontext;
    }

    public void setCcontext(String ccontext) {
        this.ccontext = ccontext;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCuser_img() {
        return cuser_img;
    }

    public void setCuser_img(String cuser_img) {
        this.cuser_img = cuser_img;
    }

    @Override
    public String toString() {
        return "comment{" +
                "cid=" + cid +
                ", article_id=" + article_id +
                ", ccontext='" + ccontext + '\'' +
                ", cusername='" + cusername + '\'' +
                ", ctime='" + ctime + '\'' +
                ", cuser_img='" + cuser_img + '\'' +
                '}';
    }



}
