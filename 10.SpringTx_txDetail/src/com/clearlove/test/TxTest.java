package com.clearlove.test;

import com.clearlove.service.BookService;
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

    @Test
    public void test() throws FileNotFoundException {
        BookService bookService = ioc.getBean(BookService.class);
//        bookService.checkout("Tom", "ISBN-001");

        int price = bookService.getPrice("ISBN-001");
    System.out.println("读取到的数据：" + price);
    }
}
