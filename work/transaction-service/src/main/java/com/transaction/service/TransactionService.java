package com.transaction.service;

import com.yk.common.domain.Result;
import com.transaction.domain.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionService {
    /**
     * 添加事务
     * @param title 标题
     * @param content 内容
     * @return 结果集
     */
    Result saveTransaction(String title,String content);

    /**
     * 改变事务状态
     * @param id 事务id
     * @param type 状态
     * @return 结果集
     */
    Result changeTransaction(Integer id,Integer type);

    /**
     * 改变所有事务状态
     * @param type 状态
     * @return 结果集
     */
    Result changeAllTransaction(Integer type);

    /**
     * 删除指定状态的所有事务
     * @param type 状态
     * @return 结果集
     */
    Result deleteAllTransactionByType(Integer type);
    /**
     * 查询单件事务
     * @param id 事务id
     * @return 结果集
     */
    Result<Transaction> findOneTransactionById(Integer id);
    /**
     * 分页查询事务
     * @param type 事务类型
     * @param pageNum 分页起点
     * @param pageSize 分页大小
     * @return 结果集
     */
    Result<List<Transaction>> findAllTransactionByPage(Integer type, Integer pageNum, Integer pageSize);

    /**
     * @param type  事务类型
     * @param pageNum 分页起点
     * @param pageSize 分页大小
     * @param keyword 关键词
     * @return 结果集
     */
    Result<List<Transaction>> findAllTransactionByPageAndKeyWord(Integer type, Integer pageNum, Integer pageSize,String keyword);
}
