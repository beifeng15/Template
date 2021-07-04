package com.wu.service;


import com.wu.dao.GoodsDao;
import com.wu.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/9/1 16:39
 * @Version 1.0
 **/
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Transactional(rollbackFor = Exception.class)
    public void helper(Integer goodsId){
        Goods goods = goodsDao.findAmountById(goodsId);
        System.out.println(goods.getAmount());
        goods.setAmount(goods.getAmount()+1);
        goodsDao.updateGoods(goods);
        int i = 1/0;

    }
    public void c(){
        helper(1);
    }

}

