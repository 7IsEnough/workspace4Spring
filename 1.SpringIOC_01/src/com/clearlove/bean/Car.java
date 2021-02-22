package com.clearlove.bean;

/**
 * @author promise
 * @date 2021/2/21 - 13:40
 */
public class Car {

  private String carName;
  private String price;
  private String color;

  public Car() {
    System.out.println("car被创建。。");
  }

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Car{"
        + "carName='"
        + carName
        + '\''
        + ", price='"
        + price
        + '\''
        + ", color='"
        + color
        + '\''
        + '}';
  }
}
