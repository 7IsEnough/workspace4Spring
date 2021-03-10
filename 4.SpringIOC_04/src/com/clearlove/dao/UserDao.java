package com.clearlove.dao;

import com.clearlove.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author promise
 * @date 2021/3/10 - 22:32
 */
@Repository
public class UserDao extends BaseDao<User> {

    @Override
    public void save() {
        System.out.println("UserDao...保存用户.....");
    }
}
