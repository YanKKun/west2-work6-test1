package com.transaction.controller;

import cn.yk.starter.RateLimit.rateLimiting;
import com.yk.common.domain.Result;
import com.transaction.domain.Transaction;
import com.transaction.domain.dto.TransactionDto;
import com.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * 事务模块接口
 * @author 12080
 */
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * 添加事务
     * @param transaction 事务
     * @return 结果集
     */
    @PostMapping("/add")
    public Result addTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction.getTitle(),transaction.getContent());
    }

    /**
     * 改变事务状态
     * @param transaction 事务
     * @return 结果集
     */
    @PostMapping("/changeOne")
    public Result changeTransaction(@RequestBody Transaction transaction){
        return transactionService.changeTransaction(transaction.getId(),transaction.getType());
    }

    /**
     * 改变所有事务
     * @param transaction 事务
     * @return 结果集
     */
    @PostMapping("/changeAll")
    public Result changeAllTransaction(@RequestBody Transaction transaction){
        return transactionService.changeAllTransaction(transaction.getType());
    }

    /**
     * 删除所有指定类型的事务
     * @param transaction 事务
     * @return 结果集
     */
    @PostMapping("/deleteByType")
    public Result deleteAllTransactionByType(@RequestBody Transaction transaction){
        return transactionService.deleteAllTransactionByType(transaction.getType());
    }

    /**
     * 根据id查找事务
     * @param transaction 事务
     * @return 结果集
     */
    @GetMapping("/find")
    @rateLimiting(maxTimes = 10,key = "find-",second = 100,timeType = ChronoUnit.MINUTES)
    public Result<Transaction> findOneTransactionById(@RequestBody Transaction transaction){
        return transactionService.findOneTransactionById(transaction.getId());
    }

    /**
     * 查询所有事务
     * @param transaction 事务
     * @return 结果集
     */
    @GetMapping("/findAll")
    public Result<List<Transaction>> findAllTransactionByPage(@RequestBody TransactionDto transaction){
        return transactionService.findAllTransactionByPage(transaction.getType(), transaction.getPageNum(), transaction.getPageSize());
    }

    /**
     * 通过关键字查找
     * @param transactionDto 事务
     * @return 结果集
     */
    @GetMapping("/findAllByKeyword")
    public Result<List<Transaction>> findAllTransactionByPageAndKeyWord(@RequestBody TransactionDto transactionDto){
        return transactionService.findAllTransactionByPageAndKeyWord(transactionDto.getType(), transactionDto.getPageNum(), transactionDto.getPageSize(), transactionDto.getKeyword());
    }
}
