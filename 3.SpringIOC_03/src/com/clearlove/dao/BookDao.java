package com.clearlove.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author promise
 * @date 2021/3/6 - 20:46 id 默认就是类名首字母小写
 */
@Repository
// @Scope(value = "prototype")
public class BookDao {

//  @Autowired
//  private DataSource dataSource;

  public void saveBook() throws SQLException {
//    dataSource.getConnection();
    System.out.println("图书已经保存...");
  }
}
