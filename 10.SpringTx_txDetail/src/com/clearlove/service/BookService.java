package com.clearlove.service;

import com.clearlove.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author promise
 * @date 2021/3/25 - 22:30
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     *
     * @param username
     * @param isbn
     *
     * 事务细节
     * isolation-Isolation: 事务的隔离级别
     * propagation-Propagation: 事务的传播行为
     *
     *
     * noRollbackFor-Class[]: 哪些异常事务可以不回滚
     * noRollbackForClassName-String[](String全类名):
     *
     * rollbackFor-Class[]: 哪些异常事务需要回滚
     * rollbackForClassName-String[]:
     *
     * 异常分类：
     *      运行时异常(非检查异常)：可以不用处理；默认都回滚
     *      编译时异常(检查异常)：要么try-catch，要么在方法上声明throws
     *                 默认不回滚
     *
     * 事务的回滚：默认发生运行时异常都回滚，发生编译时异常不会回滚
     * noRollbackFor: 哪些异常事务可以不回滚(可以让原来默认回滚的异常不回滚)
     *      noRollbackFor = {ArithmeticException.class, NullPointerException.class}
     * noRollbackForClassName
     *
     * rollbackFor: 原本不回滚(原本编译时异常是不回滚的)的异常指定让其回滚
     *       rollbackFor = {FileNotFoundException.class}
     *
     *
     * readOnly-boolean: 设置事务为只读事务
     *      可以进行事务优化
     *      readOnly=true：加快查询速度，不用管事务那一堆操作了。
     *
     * timeout-int(秒为单位): 超时：事务超出指定执行时长后自动终止并回滚
     *
     *
     */
    @Transactional(timeout = 3, readOnly = false)
    public void checkout(String username, String isbn) throws FileNotFoundException {
        // 1.减库存
        bookDao.updateStock(isbn);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 2.减余额
        bookDao.updateBalance(username, bookDao.getPrice(isbn));

//        int i = 10/0;
        new FileInputStream("D://hahaha.aa");
    }

    /**
     * 根据业务的特性调整隔离级别
     * @param isbn
     * @return
     */
    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public int getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }
}
