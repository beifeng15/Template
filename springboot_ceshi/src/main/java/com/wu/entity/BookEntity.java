package com.wu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @auther Mr.Wu
 * @date 2021/5/29 10:54
 */
@Data
@AllArgsConstructor
public class BookEntity {
    private String bookName;
    private String authorName;

    private Date authorBirthday;

    // 一个Json字符串
    private String bookInformation;
    private Byte type;
}
