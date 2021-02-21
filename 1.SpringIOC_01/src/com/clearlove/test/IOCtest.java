package com.clearlove.test;

import com.clearlove.bean.Book;
import com.clearlove.bean.Car;
import com.clearlove.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author promise
 * @date 2021/1/11 - 22:16
 */
public class IOCtest {

  //    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
  private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

  /**
   * 存在的几个问题： 1.src：源码包开始的路径，成为类路径的开始； 所有源码包里面的东西都会被合并放在类路径里面 java: /bin web: /WEB-INF/classes
   *
   * <p>2.导包commons-logging-1.1.3.jar(依赖) 3.先导包再创建配置文件： 4.Spring容器接管了Person类
   */

  /**
   * 几个细节： 1.ApplicationContext(IOC容器的接口) 2.给容器注册了一个组件，也从容器中按照id拿到了这个组件的对象 组件的创建工作，是容器完成
   * Person对象什么时候创建好 容器中对象的创建在容器创建完成的时候就已经创建好了 3.同一个组件在ioc容器中是单实例的；容器启动完成都已经创建准备好的
   * 4.容器中如果没有这个组件，获取组件？报异常 NoSuchBeanDefinitionException: No bean named 'person03' is defined
   * 5.IOC容器在创建这个组件对象的时候，(property)会利用setter方法为javaBean的属性进行赋值
   * 6.javaBean的属性名是由什么决定的？getter/setter方法是属性名；set去掉后面那一串首字母小写就是属性名; 不是由 private String lastName决定
   * 所有getter/setter都自动生成
   */

  /** * 从容器中拿到这个组件 */
  @Test
  public void test() {
    // ApplicationContext:代表IOC容器
    // ClassPathXmlApplicationContext：当前应用的xml配置文件在ClassPath下
    // 根据spring配置文件得到ioc容器对象
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

    System.out.println("容器启动完成。。");
    // 容器帮我们创建好对象了
    Person bean = (Person) ioc.getBean("person01");
    Person bean2 = (Person) ioc.getBean("person01");

    System.out.println(bean == bean2);

    System.out.println("===============");
    Person bean3 = (Person) ioc.getBean("person03");
  }

  /**
   * 根据bean的类型从IOC容器中获取bean的实例 NoUniqueBeanDefinitionException expected single matching bean but
   * found 2: person01,person02 如果ioc容器中这个类型的bean有多个，查找就会报错
   */
  @Test
  public void test02() {
    //        Person bean = ioc.getBean(Person.class);
    //        System.out.println(bean);

    Person bean2 = ioc.getBean("person02", Person.class);
    System.out.println(bean2);

    Object bean = ioc.getBean("person06");
    System.out.println(bean);
  }

  /** 正确的为各种类型赋值 测试使用Null值、默认引用类型就是Null;基本类型是默认值 */
  @Test
  public void test03() {
    Person bean = (Person) ioc.getBean("person01");
    System.out.println(bean.getLastName() == null);
    System.out.println("person的car" + bean.getCar());
    Car bean2 = (Car) ioc.getBean("car01");
    bean2.setCarName("haha");
    System.out.println("我修改了容器中的car，你的car变了没？" + bean.getCar());

    Car car = bean.getCar();
    System.out.println(bean2 == car);
  }

  @Test
  public void test04() {
    Person person01 = (Person) ioc.getBean("person01");

    Car car = person01.getCar();
    System.out.println(car);

    Person person02 = (Person) ioc.getBean("person02");
    List<Book> books = person02.getBooks();
    System.out.println(books);

    System.out.println("=================");
    Object bean = ioc.getBean("carInner");
    System.out.println(bean);
  }
}
