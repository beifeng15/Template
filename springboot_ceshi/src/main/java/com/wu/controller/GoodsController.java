package com.wu.controller;

import com.wu.service.GoodsService;
import com.wu.service.Transaction_Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Mr.Wu  https://blog.csdn.net/Winter_chen001/article/details/77249029(整合)
 * @Date 2020/6/7 11:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("wu")
@Slf4j
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    Transaction_Test transaction_test;
    @Value("${name}")
    private String name;
    @GetMapping("/goods/{id}")
    public void getInt(@PathVariable("id")Integer id){
      goodsService.helper(id);
    }
    @GetMapping("/test/{id}")
    public void test(@PathVariable("id")Integer id){
        transaction_test.A();
    }

    @GetMapping("/env")
    public String test_env(){
        System.out.println("22:37");
        System.out.println("23:08");
        System.out.println("23:24");
        return "hello"+this.name;
    }





}
