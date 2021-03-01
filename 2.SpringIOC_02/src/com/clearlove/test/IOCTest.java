package com.clearlove.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author promise
 * @date 2021/3/1 - 22:01
 */
public class IOCTest {

    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 单例：Bean的生命周期
     *      (容器启动)构造器 --> 初始化方法 --> (容器关闭)销毁方法
     * 多实例：
     *      获取bean(构造器 --> 初始化方法) --> 容器关闭不会调用bean的销毁方法
     */
    @Test
    public void test() {
        Object bean = ioc.getBean("book01");
        System.out.println("容器关闭了.....");
        ioc.close();
    }
}
