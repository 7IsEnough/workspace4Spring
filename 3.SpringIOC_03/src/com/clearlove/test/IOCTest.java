package com.clearlove.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author promise
 * @date 2021/3/6 - 22:55
 */
public class IOCTest {

  ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

  /**
   * java.lang.NoClassDefFoundError: org/springframework/aop/TargetSource
   * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的
   * 1.组件的id，默认就是组件的类名首字母小写
   * 2.组件的作用域，默认都是单例的
   */
  @Test
  public void test() {
    Object bean = ioc.getBean("bookDao");
    Object bean2 = ioc.getBean("bookDao");
    System.out.println(bean == bean2);
  }
}
