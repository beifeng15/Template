package com.wu.dao;

import com.wu.enums.BookType;
import com.wu.info.BookInfo;
import lombok.Data;

/**
 * @auther Mr.Wu
 * @date 2021/5/29 10:55
 */
@Data
public class BookDto {
    private String bookName;

    // 有两个属性 name 和 birthday
    private AuthorDTO author;

    // 一个枚举类型
    private BookType bookType;

    // 一个类包含 ISBN 和 page
    private BookInfo bookInfo;
}
