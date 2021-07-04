package com.wu.config;

import com.wu.pojo.TestWu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Mr.Wu
 * @date 2021/6/26 10:56
 */
@Configuration
public class ProfileTestConfiguration {

    @Bean
    @MyConditionAnnotation(advantage = "帅")
    public TestWu giveYouOneGirlFriend() {
        return new TestWu("章子怡");
    }
}

