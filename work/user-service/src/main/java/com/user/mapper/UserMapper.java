package com.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.domain.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 新建用户
     * @param username 用户名
     * @param password 密码
     */
    @Insert("insert into user set username=#{username},password = #{password},created_time=NOW()")
    void saveUser(@Param("username")String username,@Param("password")String password);

    /**
     * 通过用户名返回对应用户
     * @param username 用户名
     * @return 用户
     */
    @Select("select id,password,username from user where username = #{username}")
    User findByUserName(@Param("username") String username);

    /**
     * 通过用户id返回指定用户
     * @param id 用户id
     * @return 用户
     */
    @Select("select username,password,id from user where id = #{id}")
    User findByUserId(@Param("id") Integer id);

    /**
     * 修改用户基本信息
     * @param password 密码
     * @param id 用户id
     */
    @Update("update user set password = #{password} where id = #{id}")
    void updateUserInfo(@Param("password") String password ,@Param("id") Integer id);

    /**
     * 增加总量
     * @param num 数量
     * @param id 用户id
     */
    @Update("update user set total = #{num} + total where id = #{id}")
    void increaseTotal(@Param("num")Integer num,@Param("id")Integer id);

    /**
     * 减少总量
     * @param num 数量
     * @param id 用户id
     */
    @Update("update user set total = total - #{num} where id = #{id}")
    void decreaseTotal(@Param("num")Integer num,@Param("id")Integer id);
}
