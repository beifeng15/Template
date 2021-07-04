package com.wu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/9/6 14:51
 * @Version 1.0
 **/
@Service
public class Transaction_Test {
  @Autowired
  GoodsService goodsService;

    public void A(){
        goodsService.helper(1);
    }
}
