package com.clearlove.utils;

import java.util.Arrays;

/**
 * @author promise
 * @date 2021/3/13 - 17:58
 */
public class LogUtils {

    public static void logStart(Object... objects) {
        System.out.println("xxx方法开始了，它使用的参数是 "+ Arrays.asList(objects));
    }
}
