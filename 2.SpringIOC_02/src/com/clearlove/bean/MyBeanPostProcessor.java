package com.clearlove.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author promise
 * @date 2021/3/2 - 21:31
 * 1.编写后置处理器的实现类
 * 2.将后置处理器配置在文件中
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 初始化之前调用
     * @param bean 将要初始化的bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "bean将要调用初始化方法了....这个bean是这样" + bean);
        // 返回传入的bean
        return bean;
    }

    /**
     * 初始化方法之后调用
     * @param bean
     * @param beanName bean在xml中配置的id
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "bean初始化方法调用完了...AfterInitialization...");
        // 初始化之后返回的bean：返回的是什么，容器中保存的就是什么
        return bean;
    }
}
