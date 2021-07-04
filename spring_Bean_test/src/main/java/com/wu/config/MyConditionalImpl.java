package com.wu.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @auther Mr.Wu
 * @date 2021/6/26 10:57
 */
public class MyConditionalImpl implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取在@MyConditionAnnotation上设置的advantage的值，如果是"帅"则
        // 如果是"丑"则为false
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(MyConditionAnnotation.class.getName());
        String advantage = attrs.get("advantage").get(0).toString();
        System.out.println("advantage: " + advantage);
        return "帅".equals(advantage);
    }
}
