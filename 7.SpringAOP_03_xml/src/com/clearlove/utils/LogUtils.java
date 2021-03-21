package com.clearlove.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author promise
 * @date 2021/3/13 - 17:58
 * 如何将这个类(切面类)中的这些方法(通知方法)动态的在目标方法运行的各个位置切入
 */

public class LogUtils {


  public static void logStart(JoinPoint joinPoint) {
    // 获取到目标方法运行时使用的参数
    Object[] args = joinPoint.getArgs();
    // 获取方法签名
    Signature signature = joinPoint.getSignature();
    String name = signature.getName();
    System.out.println("LogUtils-前置" + name + "方法开始执行，用的参数列表：" + Arrays.asList(args));
  }


  public static void logReturn(JoinPoint joinPoint, Object result) {
    String name = joinPoint.getSignature().getName();
    System.out.println("LogUtils-返回" + name + "方法正常执行完成，计算结果是：" + result);
  }



  public static void logException(JoinPoint joinPoint, Exception exception) {
    Object[] args = joinPoint.getArgs();
    System.out.println("LogUtils-异常" +
            joinPoint.getSignature().getName() + "方法执行出现异常了，异常信息是："+ exception +"这个异常已经通知测试小组进行排查");
  }


  private int logEnd(JoinPoint joinPoint) {
    System.out.println("LogUtils-后置" + joinPoint.getSignature().getName() + "方法最终结束了");
    return 0;
  }



  public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

    Object[] args = pjp.getArgs();


    Object proceed = null;
    try {
      //@Before
      System.out.println("环绕前置通知："+ pjp.getSignature().getName() +"方法开始");
      // 利用反射调用目标方法即可，就是method.invoke(obj, args)
      proceed = pjp.proceed(args);
      //@AfterReturning
      System.out.println("环绕返回通知："+ pjp.getSignature().getName() +"方法返回：" + proceed);
    } catch (Exception e) {
      //@AfterThrowing
      System.out.println("环绕异常通知："+ pjp.getSignature().getName() +"方法出现异常，异常信息：" + e);
      // 为了让外界能知道这个异常，这个异常一定跑出去
      throw new RuntimeException(e);
    } finally{
      //@After
      System.out.println("环绕后置通知："+ pjp.getSignature().getName() +"方法结束");
    }

    // 反射调用后的返回值也一定返回出去
    return proceed;
  }
}
