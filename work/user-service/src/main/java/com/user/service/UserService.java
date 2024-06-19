package com.user.service;


import com.yk.common.domain.Result;
import com.user.domain.po.User;
import org.springframework.stereotype.Service;

/**
 * @author 12080
 */
@Service
public interface UserService {
    /**
     * 新建用户
     * @param username 用户名
     * @param password 密码
     * @return  结果集
     */
    Result register(String username , String password);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 结果集
     */
    Result login(String username,String password);

    /**
     * 通过用户id返回指定用户
     * @param id 用户id
     * @return 用户
     */
    Result<User> findByUserId(Integer id);

    /**
     * 增加总量
     * @param num 数量
     * @return 结果集
     */
    Result increaseTotal(Integer num);

    /**
     * 减少总量
     * @param num 数量
     * @return 结果集
     */
    Result decreaseTotal(Integer num);

}
