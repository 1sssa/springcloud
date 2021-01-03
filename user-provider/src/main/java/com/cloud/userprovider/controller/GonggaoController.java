package com.cloud.userprovider.controller;


import com.cloud.common.Gonggao;
import com.cloud.userprovider.dao.GonggaoDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GonggaoController {
    @Autowired
    GonggaoDao gonggaoDao;


    @RequestMapping(value = "/findGonggao",method = RequestMethod.GET)
    public Gonggao findGonggao(@Param("ggid") String ggid){
        return gonggaoDao.findGonggao(ggid);
    }

    @RequestMapping(value = "/deleteGonggao",method = RequestMethod.GET)
    public int deleteGonggao(@Param("ggid") String ggid){
        return gonggaoDao.deleteGonggao(ggid);
    }


    @RequestMapping(value = "/updateGonggao",method = RequestMethod.GET)
    public int updateGonggao(@Param(value = "gguname") String gguname,@Param(value = "ggcontent") String ggcontent,@Param(value = "ggtype") String ggtype,@Param(value = "ggtime") String ggtime,@Param("ggid") String ggid){
        return gonggaoDao.updateGonggao(gguname,ggcontent,ggtype,ggtime,ggid);
    }


    @RequestMapping(value = "/addGonggao",method = RequestMethod.GET)
    public int addGonggao(@Param("ggid") String ggid, @Param(value = "gguname") String gguname,@Param(value = "ggcontent") String ggcontent,@Param(value = "ggtype") String ggtype,@Param(value = "ggtime") String ggtime){
        return gonggaoDao.addGonggao(ggid,gguname,ggcontent,ggtype,ggtime);
    }


}
