package com.clearlove.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author promise
 * @date 2021/3/13 - 17:58
 * 如何将这个类(切面类)中的这些方法(通知方法)动态的在目标方法运行的各个位置切入
 */
@Aspect
@Component
public class LogUtils {

  /**
   * 告诉Spring每个方法都什么时候运行
   * try{
   *    @Before
   *    method.invoke(obj, args);
   *    @AfterReturning
   * } catch(e) {
   *    @AfterThrowing
   * } finally {
   *    @After
   * }
   *
   * 5个通知注解
   * @Before: 在目标方法之前运行；                 前置通知
   * @After： 在目标方法结束之后运行；             后置通知
   * @AfterReturning： 在目标方法正常返回之后；    返回通知
   * @AfterThrowing： 在目标方法抛出异常之后运行； 异常通知
   * @Around： 环绕                              环绕通知
   */

  // 想在执行目标方法之前运行：写切入点表达式
  // execution(方法权限符 返回值类型 方法签名)
  @Before("execution(public int com.clearlove.impl.MyMathCalculator.*(int, int))")
  public static void logStart() {
    System.out.println("[xxx]方法开始执行，用的参数列表xxx");
  }

  // 想在目标方法正常执行完成之后执行
  @AfterReturning("execution(public int com.clearlove.impl.MyMathCalculator.*(int, int))")
  public static void logReturn() {
    System.out.println("[xxxx]方法正常执行完成，计算结果是：xxx");
  }

  // 想在目标方法出现异常的时候执行
  @AfterThrowing("execution(public int com.clearlove.impl.MyMathCalculator.*(int, int))")
  public static void logException() {
    System.out.println(
        "[xxxx]方法执行出现异常了，异常信息是：xxxx：这个异常已经通知测试小组进行排查");
  }

  // 想在目标方法结束的时候执行
  @After("execution(public int com.clearlove.impl.MyMathCalculator.*(int, int))")
  public static void logEnd() {
    System.out.println("[xxx]方法最终结束了");
  }
}