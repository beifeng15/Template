package com.cht.springboot.redis.cluster;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/12/13 15:43
 * @Version 1.0
 **/

public class Test01 {

    @Test
    public void test02(){
        byte b = 97;
        int b1 = b;

        System.out.println((char) b);

        String string = Character.toString((char) b);
        char[] chars = Character.toChars(b);
        System.out.println(Character.toChars(b));
        System.out.println(Character.toChars(b1));
    }
}
