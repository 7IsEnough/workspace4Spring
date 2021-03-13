package com.clearlove.test;

import com.clearlove.impl.MyMathCalculator;
import com.clearlove.inter.Calculator;
import com.clearlove.proxy.CalculatorProxy;
import org.junit.Test;

/**
 * @author promise
 * @date 2021/3/13 - 17:50
 */
public class AOPTest {

  @Test
  public void test() {
    Calculator calculator = new MyMathCalculator();

    calculator.add(1, 2);

    calculator.div(2, 1);

    System.out.println("==================");

    // 如果是拿到了这个对象的代理对象；代理对象执行加减乘除
    Calculator proxy =  CalculatorProxy.getProxy(calculator);
    proxy.add(2, 1);
  }
}
