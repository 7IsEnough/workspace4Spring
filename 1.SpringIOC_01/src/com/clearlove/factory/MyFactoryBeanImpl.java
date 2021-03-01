package com.clearlove.factory;

import com.clearlove.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * @author promise
 * @date 2021/3/1 - 21:28
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * Spring会自动调用工厂方法创建实例
 * 1.编写一个FactoryBean的实现类
 * 2.在spring配置文件中进行注册
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    /**
     *
     * @return
     * @throws Exception
     * 工厂方法：返回创建的对象
     */
    @Override
    public Book getObject() throws Exception {
    System.out.println("MyFactoryBeanImpl....帮你创建对象...");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建的对象的类型
     * spring会自动调用这个方法来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是单例？
     * false：不是单例
     * true：是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
