package com.wu.dao;

import com.wu.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/9/1 16:53
 * @Version 1.0
 **/
@Mapper
@Component
public interface GoodsDao {
     Goods findAmountById(int id);
    Integer updateGoods(Goods goods);
}
