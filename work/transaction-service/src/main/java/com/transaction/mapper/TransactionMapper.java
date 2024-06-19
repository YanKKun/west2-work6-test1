package com.transaction.mapper;

import com.transaction.domain.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {
    /**
     * 添加事务
     * @param createUserId 创建者id
     * @param title 标题
     * @param content 内容
     */
    @Insert("insert into transaction set create_user_id = #{create_user_id} , title = #{title} , content = #{content} ,created_time = NOW()")
    void saveTransaction(@Param("create_user_id") Integer createUserId,@Param("title")String title,@Param("content")String content);

    /**
     * 删除一条事务
     * @param id 事务id
     */
    @Update("update transaction set type = 2 , is_deleted = 1 where id = #{id} and is_deleted = 0")
    void deleteTransaction(@Param("id")Integer id);

    /**
     * 删除所有已完成事务
     * @param createUserId 创建者id
     * @return 删除数量
     */
    @Update("update transaction set type = 2 , is_deleted = 1 where create_user_id = #{create_user_id} and type = 1 and is_deleted = 0")
    Integer deleteAllFinishTransaction(@Param("create_user_id")Integer createUserId);

    /**
     * 删除所有待办事务
     * @param createUserId 创建者id
     * @return 删除数量
     */
    @Update("update transaction set type = 2 , is_deleted = 1 where create_user_id = #{create_user_id} and type = 0 and is_deleted = 0")
    Integer deleteAllToDoTransaction(@Param("create_user_id")Integer createUserId);

    /**
     * 删除所有事务
     * @param createUserId 创建者id
     * @return 删除数量
     */
    @Update("update transaction set type = 2 , is_deleted = 1 where create_user_id = #{create_user_id} and is_deleted = 0")
    Integer deleteAllTransaction(@Param("create_user_id")Integer createUserId);
    /**
     * 完成事务
     * @param id 事务id
     */
    @Update("update transaction set type = 1  where id = #{id} and is_deleted = 0")
    void finishTransaction(@Param("id")Integer id);

    /**
     * 待办事务
     * @param id 事务id
     */
    @Update("update transaction set type = 0  where id = #{id} and is_deleted = 0")
    void toDoTransaction(@Param("id")Integer id);

    /**
     * 完成所有事务
     * @param createUserId 创建者id
     */
    @Update("update transaction set type = 1  where create_user_id = #{create_user_id} and type = 0 and is_deleted = 0")
    void finishAllTransaction(@Param("create_user_id")Integer createUserId);

    /**
     * 待办所有事务
     * @param createUserId 创建者id
     */
    @Update("update transaction set type = 0  where create_user_id = #{create_user_id} and type = 1 and is_deleted = 0")
    void toDoAllTransaction(@Param("create_user_id")Integer createUserId);

    /**
     * 查询单件事务
     * @param id 事务id
     * @return  事务
     */
    @Select("select id, create_user_id, title, content, type, created_time  from transaction where id = #{id} and is_deleted = 0")
    Transaction findOneTransactionById(@Param("id")Integer id);

    /**
     * 分页查询事务
     * @param type 事务类型
     * @param createUserId 创建者id
     * @param pageNum 分页起点
     * @param pageSize 分页大小
     * @return 对象集
     */
    @Select("select id, create_user_id, title, content, type, created_time  from transaction where type = #{type} and create_user_id = #{create_user_id} and is_deleted = 0 limit #{pageNum},#{pageSize}")
    List<Transaction> findAllTransactionByPage(@Param("type")Integer type, @Param("create_user_id")Integer createUserId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     * 分页查询事务
     * @param type 事务类型
     * @param createUserId 创建者id
     * @param pageNum 分页起点
     * @param pageSize 分页大小
     * @param keyword 关键字
     * @return 对象集
     */
    @Select("select id, create_user_id, title, content, type, created_time  from transaction where type = #{type} and create_user_id = #{create_user_id} and is_deleted = 0 and content like concat('%',#{keyword},'%') or title like concat('%',#{keyword},'%') limit #{pageNum},#{pageSize}")
    List<Transaction> findAllTransactionByPageAndKeyWord(@Param("type")Integer type, @Param("create_user_id")Integer createUserId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize,@Param("keyword")String keyword);


}
