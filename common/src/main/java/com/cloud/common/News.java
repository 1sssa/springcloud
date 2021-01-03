package com.cloud.common;

public class News {

    public int nid;          //新闻id
    public String ntitle;    //新闻标题
    public String nsummary;  //新闻概述
    public String ndetails;  //新闻详情
    public String ndate;     //日期
    public String nkeyword;  //新闻关键词
    public String nimgURL;   //图片路径
    public Integer ntypes;    //新闻类型
    public String nsource;   //新闻来源
    public String neditor;   //新闻编辑
    public int nhot;          //新闻热度（阅读量）

    public int getNhot() {
        return nhot;
    }

    public void setNhot(int nhot) {
        this.nhot = nhot;
    }


    public Integer getNtypes() {
        return ntypes;
    }

    public void setNtypes(Integer ntypes) {
        this.ntypes = ntypes;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }

    public String getNdetails() {
        return ndetails;
    }

    public void setNdetails(String ndetails) {
        this.ndetails = ndetails;
    }

    public String getNdate() {
        return ndate;
    }

    public void setNdate(String ndate) {
        this.ndate = ndate;
    }

    public String getNkeyword() {
        return nkeyword;
    }

    public void setNkeyword(String nkeyword) {
        this.nkeyword = nkeyword;
    }

    public String getNimgURL() {
        return nimgURL;
    }

    public void setNimgURL(String nimgURL) {
        this.nimgURL = nimgURL;
    }



    public String getNsource() {
        return nsource;
    }

    public void setNsource(String nsource) {
        this.nsource = nsource;
    }

    public String getNeditor() {
        return neditor;
    }

    public void setNeditor(String neditor) {
        this.neditor = neditor;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", ntitle='" + ntitle + '\'' +
                ", nsummary='" + nsummary + '\'' +
                ", ndetails='" + ndetails + '\'' +
                ", ndate='" + ndate + '\'' +
                ", nkeyword='" + nkeyword + '\'' +
                ", nimgURL='" + nimgURL + '\'' +
                ", ntypes=" + ntypes +
                ", nsource='" + nsource + '\'' +
                ", neditor='" + neditor + '\'' +
                ", nhot=" + nhot +
                '}';
    }

}
