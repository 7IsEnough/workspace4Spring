package com.clearlove.test;

import com.clearlove.impl.MyMathCalculator;
import com.clearlove.inter.Calculator;
import com.clearlove.proxy.CalculatorProxy;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author promise
 * @date 2021/3/13 - 17:50
 */
public class AOPTest {

  /**
   * 有了动态代理，日志记录可以做的非常强大；而且与业务逻辑解耦
   * jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为他创建代理对象的
   */
  @Test
  public void test() {
    Calculator calculator = new MyMathCalculator();

    calculator.add(1, 2);

    calculator.div(2, 1);

    System.out.println("==================");

    // 如果是拿到了这个对象的代理对象；代理对象执行加减乘除
    Calculator proxy =  CalculatorProxy.getProxy(calculator);
    // class com.sun.proxy.$Proxy7
    // 代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
    System.out.println(proxy.getClass());
    // 该代理对象也是实现了Calculator接口
    System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
    proxy.add(2, 1);
    proxy.div(2, 0);
  }
}
