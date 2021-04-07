package com.clearlove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author promise
 * @date 2021/4/7 - 23:02
 */
@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx() {
        // 回滚不回滚都是可以设置的
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务(使用同一条连接)
        // REQUIRED  REQUIRES_NEW
        bookService.checkout("Tom", "ISBN-001");

        // REQUIRED
        bookService.updatePrice("ISBN-002", 998);

//        int i = 10/0;
    }
}
