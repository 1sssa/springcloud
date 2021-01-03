package com.cloud.userprovider.dao;



import com.cloud.common.Gonggao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "GonggaoDao")
public interface GonggaoDao {



    Gonggao findGonggao(@Param("ggid") String ggid);


    int deleteGonggao(@Param("ggid") String ggid);

    int updateGonggao(@Param(value = "gguname") String gguname, @Param(value = "ggcontent") String ggcontent, @Param(value = "ggtype") String ggtype, @Param(value = "ggtime") String ggtime, @Param(value = "ggid") String ggid);



    int addGonggao(@Param("ggid") String ggid, @Param(value = "gguname") String gguname, @Param(value = "ggcontent") String ggcontent, @Param(value = "ggtype") String ggtype, @Param(value = "ggtime") String ggtime);







}

