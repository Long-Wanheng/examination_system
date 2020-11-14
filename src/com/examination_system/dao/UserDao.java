package com.examination_system.dao;

import com.examination_system.model.entity.User;
import com.examination_system.model.query.UserQuery;

import java.util.List;

/**
 * @program examination-system
 * @description: exam_user操作数据库dao层接口
 * @author: yao
 * @create: 2020/11/14 13:21
 */
public interface UserDao {
    /**
     * 根据主键id查询用户实体类
     *
     * @param id 主键id
     * @return User
     */
    User getById(Long id);

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return int
     */
    int add(User user);

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return int
     */
    int update(User user);

    /**
     * 根据主键id删除用户
     *
     * @param id 主键id
     * @return int
     */
    int delete(int id);

    /**
     * 根据用户名查询用户实体类
     *
     * @param name 用户名
     * @return User
     */
    User getByName(String name);

    /**
     * 根据查询条件用户实体类集合
     *
     * @param param 查询条件
     * @return List<User>
     */
    List<User> queryList(UserQuery param);

    /**
     * 根据查询条件分页用户实体类集合
     *
     * @param param 主键id
     * @return List<User>
     */
    List<User> queryListByPage(UserQuery param);

    /**
     * 根据查询条件分页用户实总条数
     *
     * @param param 主键id
     * @return Integer
     */
    Integer queryPageCount(UserQuery param);
}
