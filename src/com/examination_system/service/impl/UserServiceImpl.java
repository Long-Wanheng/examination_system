package com.examination_system.service.impl;

import com.examination_system.dao.UserDao;
import com.examination_system.dao.impl.UserDaoImpl;
import com.examination_system.model.entity.User;
import com.examination_system.model.query.UserQuery;
import com.examination_system.service.UserService;
import com.examination_system.utils.LogUtil;
import com.examination_system.utils.Md5Util;
import com.examination_system.utils.TableData;

import java.util.List;
import java.util.logging.Logger;

/**
 * @program examination-system
 * @description: 用户服务实现类
 * @author: yao
 * @create: 2020/11/14 15:52
 */
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogUtil.getLogger();
    private final UserDao dao = new UserDaoImpl();

    /**
     * 根据主键id查询用户实体类
     *
     * @param id 主键id
     * @return User
     */
    @Override
    public User getById(Long id) {
        LOGGER.info("UserServiceImpl|getById|id: " + id);
        return dao.getById(id);
    }

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return int
     */
    @Override
    public int add(User user) {
        LOGGER.info("UserServiceImpl|add|user: " + user.toString());
        return dao.add(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return int
     */
    @Override
    public int update(User user) {
        LOGGER.info("UserServiceImpl|update|user: " + user.toString());
        return dao.update(user);
    }

    /**
     * 根据主键id删除用户
     *
     * @param id 主键id
     * @return int
     */
    @Override
    public int delete(Long id) {
        LOGGER.info("UserServiceImpl|delete|id: " + id);
        return dao.delete(id);
    }

    /**
     * 根据用户名查询用户实体类
     *
     * @param name 用户名
     * @return User
     */
    @Override
    public User getByName(String name) {
        LOGGER.info("UserServiceImpl|getByName|name: " + name);
        return dao.getByName(name);
    }

    /**
     * 根据用户名查询用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return User
     */
    @Override
    public User getLoginUser(String name, String password) {
        LOGGER.info("UserServiceImpl|getLoginUser|name: " + name + " |password: " + password);
        User user = dao.getByName(name);
        if (user == null) {
            return null;
        }
        String md5 = Md5Util.md5(password);
        if (!md5.equals(user.getPassword())){
            return null;
        }
        return user;
    }

    /**
     * 根据查询条件用户实体类集合
     *
     * @param param 查询条件
     * @return List<User>
     */
    @Override
    public List<User> queryList(UserQuery param) {
        LOGGER.info("UserServiceImpl|getByName|param: " + param.toString());
        return dao.queryList(param);
    }

    /**
     * 根据查询条件分页用户实体类信息
     *
     * @param param 主键id
     * @return TableData<User>
     */
    @Override
    public TableData<User> queryListByPage(UserQuery param) {
        LOGGER.info("UserServiceImpl|queryListByPage|param: " + param.toString());
        TableData<User> result = new TableData<User>();

        Integer total = dao.queryPageCount(param);
        if (total == null || total < 0) {
            return result;
        }

        List<User> data = dao.queryListByPage(param);
        result.setPageNum(param.getPageNum());
        result.setPageSize(param.getPageSize());
        result.setData(data);
        return result;
    }
}
