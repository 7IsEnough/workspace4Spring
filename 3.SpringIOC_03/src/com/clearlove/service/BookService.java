package com.clearlove.service;

import com.clearlove.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author promise
 * @date 2021/3/6 - 20:45
 */
@Service
public class BookService {

  @Autowired
  private BookDao bookDao;

  public void save() throws SQLException {
    System.out.println("bookService..正在调用dao帮你保存图书...");
    bookDao.saveBook();
  }
}
