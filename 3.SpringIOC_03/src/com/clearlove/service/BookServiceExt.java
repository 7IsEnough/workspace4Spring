package com.clearlove.service;

import com.clearlove.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author promise
 * @date 2021/3/8 - 22:03
 */
@Service
public class BookServiceExt extends BookService {

  @Autowired private BookDao bookDao;

  @Override
  public void save() throws SQLException {
    System.out.println("bookServiceExt....");
  }
}
