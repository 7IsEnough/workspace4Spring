package com.clearlove.bean;

/**
 * @author promise
 * @date 2021/2/21 - 13:44
 */
public class Book {

  private String bookName;
  private String author;

  public Book() {
    System.out.println("book被创建..");
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" + "bookName='" + bookName + '\'' + ", author='" + author + '\'' + '}';
  }
}
