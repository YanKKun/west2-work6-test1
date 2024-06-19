package com.user.controller;


import com.yk.common.domain.Result;
import com.user.domain.po.User;
import com.user.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户模块接口
 * @author 12080
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 登录
     * @param user 用户
     * @return 结果集
     */
    @PostMapping("/login")
    public Result login(@RequestBody @NotNull User user){
        return userService.login(user.getUsername(),user.getPassword());
    }


    /**
     * 注册
     * @param user 用户对象
     * @return 结果集
     */
    @PostMapping("/register")
    @Transactional
    public Result register(@RequestBody User user){
        return userService.register(user.getUsername(), user.getPassword());
    }


    /**
     * 通过id查找用户
     * @param user 用户对象
     * @return 结果集
     */
    @GetMapping("/findUserById")
    public Result findByUserId(@Valid @RequestBody User user){
        return userService.findByUserId(user.getId());
    }

    /**
     * 增加总量
     * @param num 数量
     * @return 结果集
     */
    @PostMapping("/increase")
    @Transactional
    public Result increaseTotal(@RequestParam Integer num){

        return userService.increaseTotal(num);
    }

    /**
     * 减少总量
     * @param num 数量
     * @return 结果集
     */
    @PostMapping("/decrease")
    @Transactional
    public Result decrease(@RequestParam Integer num){
        return userService.decreaseTotal(num);
    }


}
