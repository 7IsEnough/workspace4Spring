package com.clearlove.impl;

import com.clearlove.inter.Calculator;
import com.clearlove.utils.LogUtils;

/**
 * @author promise
 * @date 2021/3/13 - 17:48
 */
public class MyMathCalculator implements Calculator {

  @Override
  public int add(int i, int j) {
    int result = i + j;
    return result;
  }

  @Override
  public int sub(int i, int j) {
    int result = i - j;
    return result;
  }

  @Override
  public int mul(int i, int j) {
    int result = i * j;
    return result;
  }

  @Override
  public int div(int i, int j) {
    int result = i / j;
    return result;
  }
}
