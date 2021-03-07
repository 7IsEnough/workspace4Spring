package com.clearlove.test;

import com.clearlove.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

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
   * @Repository("bookdaohaha")
   * public class BookDao {}
   * 2.组件的作用域，默认都是单例的
   * @scope(value = "prototype")
   */
  @Test
  public void test() {
    Object bean = ioc.getBean("bookdaohaha");
    Object bean2 = ioc.getBean("bookdaohaha");
    System.out.println(bean == bean2);
  }

  @Test
  public void test02() throws SQLException {
    BookServlet bookServlet = ioc.getBean(BookServlet.class);
    bookServlet.doGet();
  }
}
