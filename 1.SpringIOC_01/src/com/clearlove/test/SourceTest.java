package com.clearlove.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author promise
 * @date 2021/4/3 - 9:59
 */
public class SourceTest {

  private static ApplicationContext ioc;

  public static void main(String[] args) {
    // 1.ioc容器的创建
    ioc = new ClassPathXmlApplicationContext("ioc.xml");
    Object bean = ioc.getBean("person03");
    System.out.println(bean);
  }
}
