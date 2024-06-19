package com.user.service.impl;


import com.yk.common.domain.Result;
import com.yk.common.utils.UserContext;
import com.user.config.JwtProperties;
import com.user.domain.po.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import com.user.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 12080
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    private final JwtProperties jwtProperties;
    private final JwtTool jwtTool;
    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public Result register(String username, String password) {
        log.info("数据传入");
        if(userMapper.findByUserName(username)!=null){
            return Result.error("已被注册");
        }
        userMapper.saveUser(username, passwordEncoder.encode(password));
        return Result.success();
    }

    @Override
    public Result login(String username, String password) {
        User user = userMapper.findByUserName(username);
        if (user==null){
            return Result.error("没有该用户，请注册");
        }
        if (!passwordEncoder.matches(password,user.getPassword())){
            return Result.error("密码错误");
        }
        String token = jwtTool.createToken(user.getId(), jwtProperties.getTokenTTL());
//        redisCache.setCacheObject("userId:"+user.getId(),token);
//        redisCache.expire("userId:"+user.getId(),10000);
        return Result.success(token);
    }

    @Override
    public Result<User> findByUserId(Integer id) {
        if (userMapper.findByUserId(id)==null){
            return Result.error("用户不存在");
        }
        return Result.success(userMapper.findByUserId(id));
    }

    @Override
    public Result increaseTotal(Integer num) {
        Integer user = UserContext.getUser();
        if (user==null){
            return Result.error("用户未登入");
        }
        userMapper.increaseTotal(num,user);
        return Result.success();
    }

    @Override
    public Result decreaseTotal(Integer num) {
        Integer user = UserContext.getUser();
        if (user==null){
            return Result.error("用户未登入");
        }
        userMapper.decreaseTotal(num,user);
        return Result.success();
    }
}


