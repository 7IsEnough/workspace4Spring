package com.clearlove.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.JobName;
import java.util.Arrays;

/**
 * @author promise
 * @date 2021/3/21 - 16:22
 */
@Aspect
@Component
@Order(2)
public class ValidateAspect {

  @Before("com.clearlove.utils.LogUtils.hahaMyPoint()")
  public void logStart(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    String name = joinPoint.getSignature().getName();
    System.out.println("VaAspect-前置" + name + "方法开始执行，用的参数列表：" + Arrays.asList(args));
  }

  @AfterReturning(value = "com.clearlove.utils.LogUtils.hahaMyPoint()", returning = "result")
  public void logReturn(JoinPoint joinPoint, Object result) {
    String name = joinPoint.getSignature().getName();
    System.out.println("VaAspect-返回" + name + "方法正常执行完成，计算结果是：" + result);
  }

  @AfterThrowing(value = "com.clearlove.utils.LogUtils.hahaMyPoint()", throwing = "exception")
  public void logException(JoinPoint joinPoint, Exception exception) {
    Object[] args = joinPoint.getArgs();
    System.out.println("VaAspect-异常" +
            joinPoint.getSignature().getName() + "方法执行出现异常了，异常信息是："+ exception +"这个异常已经通知测试小组进行排查");
  }

  @After("com.clearlove.utils.LogUtils.hahaMyPoint()")
  private int logEnd(JoinPoint joinPoint) {
    System.out.println("VaAspect-后置" + joinPoint.getSignature().getName() + "方法最终结束了");
    return 0;
  }
}
