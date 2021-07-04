package com.wu;


import com.wu.config.ProfileTestConfiguration;
import com.wu.pojo.TestWu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/9/8 21:18
 * @Version 1.0
 **/
@SpringBootApplication
//@Import(ProfileTestConfiguration.class)
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
       /* AnnotationConfigApplicationContext factory  = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService userService = factory.getBean("userService", UserService.class);

        System.out.println(userService);*/

       /* ConfigurableApplicationContext cac = SpringApplication.run(Main.class, args);
        TestWu bean = cac.getBean(TestWu.class);
        System.out.println(bean);*/
    }

}
