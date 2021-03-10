package com.clearlove.service;

import com.clearlove.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author promise
 * @date 2021/3/10 - 22:40
 */
public class BaseService<T> {

    @Autowired
    BaseDao<T> baseDao;

    public void save() {
        System.out.println("自动注入的dao：" + baseDao);
        baseDao.save();
    }
}
