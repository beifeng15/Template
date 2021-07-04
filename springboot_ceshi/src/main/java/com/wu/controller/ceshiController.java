package com.wu.controller;

import com.wu.dao.BookDto;
import com.wu.entity.BookEntity;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;


/**
 * @auther Mr.Wu
 * @date 2021/5/29 11:14
 */
@RequestMapping("/test")
@RestController
public class ceshiController {

    @Autowired
    private MapperFacade mapperFacade;

    @GetMapping("/convert")
    public void convert(){
        BookEntity bookEntity = new BookEntity(
                "银河系漫游指南",
                "道格拉斯·亚当斯",
                Date.from(LocalDate.of(1952, Month.MARCH, 11).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                "{\"ISBN\": \"9787532754687\", \n \"page\": 279\n }",
                new Integer(15).byteValue());

        final BookDto bookDTO = mapperFacade.map(bookEntity, BookDto.class);
        System.out.println("一个测试的节点");
    }
}
