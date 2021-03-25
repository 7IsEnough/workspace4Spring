package com.clearlove.test;

import com.clearlove.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author promise
 * @date 2021/3/25 - 22:34
 */
public class TxTest {

  ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");

  @Test
  public void test() {
    BookService bookService = ioc.getBean(BookService.class);
    bookService.checkout("Tom", "ISBN-001");
    System.out.println("结账完成");
  }
}
