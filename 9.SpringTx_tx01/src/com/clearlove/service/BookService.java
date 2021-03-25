package com.clearlove.service;

import com.clearlove.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author promise
 * @date 2021/3/25 - 22:30
 */
@Service
public class BookService {

  @Autowired BookDao bookDao;

  /**
   * 结账：传入哪个用户买了哪本书
   *
   * @param username
   * @param isbn
   */
  public void checkout(String username, String isbn) {
    // 1.减库存
    bookDao.updateStock(isbn);

    // 2.减余额
    bookDao.updateBalance(username, bookDao.getPrice(isbn));
  }
}
