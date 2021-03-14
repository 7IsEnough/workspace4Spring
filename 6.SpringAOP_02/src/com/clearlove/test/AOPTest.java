package com.clearlove.test;


import com.clearlove.impl.MyMathCalculator;
import com.clearlove.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author promise
 * @date 2021/3/13 - 17:50
 * commons-logging-1.1.3.jar
 * spring-aop-4.0.0.RELEASE.jar
 * spring-beans-4.0.0.RELEASE.jar
 * spring-context-4.0.0.RELEASE.jar
 * spring-core-4.0.0.RELEASE.jar
 * spring-expression-4.0.0.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar：基础版
 *
 * 加强版的面向切面编程(即使目标对象没有实现任何接口也能创建动态代理)
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 */
public class AOPTest {

  /** 有了动态代理，日志记录可以做的非常强大；而且与业务逻辑解耦 jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为他创建代理对象的 */
  ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

  @Test
  public void test() {

//    MyMathCalculator myMathCalculator = new MyMathCalculator();
//    myMathCalculator.add();

    // 1.从ioc容器中拿到目标对象；注意：如果想要用类型，一定用他的接口类型，不要用它本类
    // 细节一：com.clearlove.impl.MyMathCalculator@6b58b9e9
    // class com.sun.proxy.$Proxy16
    // AOP的底层就是动态代理，容器中保存的组件是他的代理对象：$Proxy16。当然不是本类的类型
//    Calculator bean = ioc.getBean(Calculator.class);
//    bean.add(2, 1);
//    System.out.println(bean);
//    System.out.println(bean.getClass());
//
//    Calculator bean2 = (Calculator) ioc.getBean("myMathCalculator");
//    System.out.println(bean2.getClass());

    // 没有接口就是本类类型
    // class com.clearlove.impl.MyMathCalculator$$EnhancerByCGLIB$$218e1b85
    // cglib帮我们创建好的代理对象
    MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
    bean.add(1, 2);
    System.out.println(bean.getClass());
  }
}
