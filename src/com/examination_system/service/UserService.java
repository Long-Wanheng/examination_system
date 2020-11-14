package com.examination_system.service;

import com.examination_system.model.entity.User;
import com.examination_system.model.query.UserQuery;
import com.examination_system.utils.TableData;

import java.util.List;

/**
 * @program examination-system
 * @description: 用户服务
 * @author: yao
 * @create: 2020/11/14 15:50
 */
public interface UserService {

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
    int delete(Long id);

    /**
     * 根据用户名查询用户实体类
     *
     * @param name 用户名
     * @return User
     */
    User getByName(String name);

    /**
     * 根据用户名查询用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return User
     */
    User getLoginUser(String name, String password);

    /**
     * 根据查询条件用户实体类集合
     *
     * @param param 查询条件
     * @return List<User>
     */
    List<User> queryList(UserQuery param);

    /**
     * 根据查询条件分页用户实体类信息
     *
     * @param param 主键id
     * @return TableData<User>
     */
    TableData<User> queryListByPage(UserQuery param);

}
