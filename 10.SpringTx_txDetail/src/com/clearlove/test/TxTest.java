package com.clearlove.test;

import com.clearlove.service.BookService;
import com.clearlove.service.MulService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * @author promise
 * @date 2021/4/3 - 16:22
 */
public class TxTest {

  ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

  /**
   * 有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象
   *
   * multx(){
   *
   *     //REQUIRED
   *     A(){
   *         //REQUIRES_NEW
   *         B(){}
   *         //REQUIRED
   *         C(){}
   *     }
   *     //REQUIRES_NEW
   *     D(){
   *         DDDD()   // 为REQUIRES_NEW不蹦，为REQUIRED崩
   *         //REQUIRED
   *         E(){
   *             //REQUIRES_NEW
   *             F(){
   *                 10/0(E崩，G崩，A,C崩)
   *             }
   *         }
   *         //REQUIRES_NEW
   *         G(){}
   *     }
   *
   *     int i = 10/0; B成功，D整个分支下全部成功
   *     任何处崩，已经执行的REQUIRES_NEW都会成功
   * }
   *
   * @throws FileNotFoundException
   */
  @Test
  public void test() throws FileNotFoundException {
    BookService bookService = ioc.getBean(BookService.class);

    MulService bean = ioc.getBean(MulService.class);
    bean.mulTx();

//    bookService.checkout("Tom", "ISBN-001");

    //        int price = bookService.getPrice("ISBN-001");
    //    System.out.println("读取到的数据：" + price);

//    System.out.println(bookService.getClass());
  }
}
