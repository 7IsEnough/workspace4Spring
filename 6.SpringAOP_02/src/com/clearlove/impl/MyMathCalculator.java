package com.clearlove.impl;

import com.clearlove.inter.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author promise
 * @date 2021/3/13 - 17:48
 */
@Service
public class MyMathCalculator /*implements Calculator*/ {


    public int add(int i, double j) {
      return 0;
    }

//  @Override
  public int add(int i, int j) {
    int result = i + j;
    return result;
  }

//  @Override
  public int sub(int i, int j) {
    int result = i - j;
    return result;
  }

//  @Override
  public int mul(int i, int j) {
    int result = i * j;
    return result;
  }

//  @Override
  public int div(int i, int j) {
    int result = i / j;
    return result;
  }
}
