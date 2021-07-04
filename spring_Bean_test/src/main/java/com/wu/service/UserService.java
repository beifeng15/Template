/*
package com.wu.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean {

    private String name;

   */
/* public void setName(String name){
        System.out.println("属性的注入");
        this.name = name;
    }*//*


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware接口--->setBeanName");
        System.out.println(s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware接口-->setBeanFactory");
        System.out.println(beanFactory.getClass().getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware接口--->setApplicationContext");
        System.out.println(applicationContext.getClass().getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean初始化接口--->afterPropertiesSet");
    }

    public void show() {
        System.out.println("show方法执行了");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("@PostConstruct--->initMethod");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy--->destroy");
    }

    public UserService() {
        System.out.println("执行构造方法");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}*/
