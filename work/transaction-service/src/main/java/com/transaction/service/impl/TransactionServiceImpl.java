package com.transaction.service.impl;

import com.api.client.UserClient;
import com.yk.common.domain.Result;
import com.yk.common.utils.UserContext;
import com.transaction.domain.Transaction;
import com.transaction.mapper.TransactionMapper;
import com.transaction.service.TransactionService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private UserClient userClient;

    @Resource
    private TransactionMapper transactionMapper;

    @Override
    @GlobalTransactional
    public Result saveTransaction( String title, String content) {
        transactionMapper.saveTransaction(UserContext.getUser(), title, content);
        userClient.increaseTotal(1);
        return Result.success();
    }

    @Override
    @GlobalTransactional
    public Result changeTransaction(Integer id, Integer type) {
        Transaction transaction = transactionMapper.findOneTransactionById(id);
        if (transaction.getType().equals(type)){
            return Result.error("操作有误");
        }
        if (!Objects.equals(transaction.getCreateUserId(), UserContext.getUser())){
            return Result.error("无操作权限");
        }
        if (type == 0){
            transactionMapper.toDoTransaction(id);
        }else if (type==1){
            transactionMapper.finishTransaction(id);
        }else if (type == 2){
            transactionMapper.deleteTransaction(id);
            userClient.decreaseTotal(1);
        }
        return Result.success();
    }

    @Override
    @GlobalTransactional
    public Result changeAllTransaction(Integer type) {
        if (type == 0){
            transactionMapper.toDoAllTransaction(UserContext.getUser());
        }else if (type==1){
            transactionMapper.finishAllTransaction(UserContext.getUser());
        }else if (type == 2){
            Integer i = transactionMapper.deleteAllTransaction(UserContext.getUser());
            userClient.decreaseTotal(i);
        }else {
            return Result.error("操作有误");
        }
        return Result.success();
    }

    @Override
    @GlobalTransactional
    public Result deleteAllTransactionByType(Integer type) {
        if (type==0){
            Integer i = transactionMapper.deleteAllToDoTransaction(UserContext.getUser());
            userClient.decreaseTotal(i);
        }else if (type == 1){
            Integer i = transactionMapper.deleteAllFinishTransaction(UserContext.getUser());
            userClient.decreaseTotal(i);
        }else {
            return Result.error("操作有误");
        }
        return Result.success();
    }

    @Override
    public Result<Transaction> findOneTransactionById(Integer id) {
        Transaction transaction = transactionMapper.findOneTransactionById(id);
        if (transaction ==null){
            return  Result.error("事务不存在");
        }
        if (!Objects.equals(transaction.getCreateUserId(), UserContext.getUser())) {
            return Result.error("无查阅权限");
        }
        return Result.success(transaction);
    }

    @Override
    public Result<List<Transaction>> findAllTransactionByPage(Integer type, Integer pageNum, Integer pageSize) {
        List<Transaction> allTransactionByPage = transactionMapper.findAllTransactionByPage(type, UserContext.getUser(), pageNum, pageSize);

        if (pageNum<0||allTransactionByPage.size()<pageSize){
            return Result.error("分页参数有误");
        }
        return Result.success(allTransactionByPage);
    }

    @Override
    public Result<List<Transaction>> findAllTransactionByPageAndKeyWord(Integer type, Integer pageNum, Integer pageSize, String keyword) {
        List<Transaction> allTransactionByPage = transactionMapper.findAllTransactionByPageAndKeyWord(type, UserContext.getUser(), pageNum, pageSize,keyword);

        if (pageNum<0||allTransactionByPage.size()<pageSize){
            return Result.error("分页参数有误");
        }
        return Result.success(allTransactionByPage);
    }
}
