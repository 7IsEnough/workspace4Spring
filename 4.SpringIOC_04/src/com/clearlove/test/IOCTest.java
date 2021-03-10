package com.clearlove.test;

import com.clearlove.service.BookService;
import com.clearlove.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author promise
 * @date 2021/3/10 - 22:42
 */
public class IOCTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() {
        BookService bookService = ioc.getBean(BookService.class);
        UserService userService = ioc.getBean(UserService.class);

        bookService.save();
        userService.save();

        // 父类是com.clearlove.service.BaseService
        // 带泛型的父类类型：com.clearlove.service.BaseService<com.clearlove.bean.Book>
        // Spring中可以使用带泛型的父类类型来确定这个子类的类型
        System.out.println(bookService.getClass().getGenericSuperclass());
    }
}
