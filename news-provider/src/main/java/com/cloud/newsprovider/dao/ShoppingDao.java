//package com.cloud.goodsprovider.dao;
//
///**
// * Created by itcast on 2019/10/31.
// */
//import com.cloud.common.Cart;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Component;
//import java.util.List;
//
//@Component
//@Mapper
//public interface ShoppingDao {
//    //查询所有购物车
//    List<Cart> getAllcart(@Param(value = "uid") int uid);
//    //插入一条购物车
//    int intcart(@Param(value = "goodsname") String goodsname, @Param(value
//            = "number") int number, @Param(value = "price") int price, @Param(value
//            = "goodid") int goodid, @Param(value = "uid") int uid);
//    //修改购物车商品数量
//    int updateCart(@Param(value = "number") int number, @Param(value = "id")
//            int id);
//}
//
