package com.wu.config;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther Mr.Wu
 * @date 2021/6/26 10:57
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Conditional(MyConditionalImpl.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConditionAnnotation {

    String advantage();
}
