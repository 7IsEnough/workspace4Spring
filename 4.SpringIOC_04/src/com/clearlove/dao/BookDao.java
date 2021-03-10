package com.clearlove.dao;

import com.clearlove.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author promise
 * @date 2021/3/10 - 22:31
 */
@Repository
public class BookDao extends BaseDao<Book>{

    @Override
    public void save() {
        System.out.println("BookDao...保存图书...");
    }
}
