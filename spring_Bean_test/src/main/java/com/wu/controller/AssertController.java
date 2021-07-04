package com.wu.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Mr.Wu
 * @date 2021/6/26 23:08
 */
@RestController
@RequestMapping("/test")
public class AssertController {

    @GetMapping("assert/{name}")
    public void assertTest(@PathVariable("name") String name){
        Assert.notNull(name,"name must not be null!");
    }
}
