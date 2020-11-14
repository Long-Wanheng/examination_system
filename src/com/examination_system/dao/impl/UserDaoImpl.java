package com.examination_system.dao.impl;

import com.examination_system.dao.UserDao;
import com.examination_system.dao.base.BeanHandler;
import com.examination_system.dao.base.BeanListHandler;
import com.examination_system.dao.base.CRUDTemplate;
import com.examination_system.model.entity.User;
import com.examination_system.model.query.UserQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * @program examination-system
 * @description: exam_user操作数据库dao层实现类
 * @author: yao
 * @create: 2020/11/14 13:37
 */
public class UserDaoImpl implements UserDao {

    private static final String SELECT_COLUMNS = "select id, name, user_no as userNo, user_type as userType, password, is_delete as isDelete ";

    /**
     * 根据主键id查询用户实体类
     *
     * @param id 主键id
     * @return User
     */
    @Override
    public User getById(Long id) {
        String sql = SELECT_COLUMNS + "  where id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        return CRUDTemplate.executeQuery(sql, new BeanHandler<>(User.class), params);
    }

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return int
     */
    @Override
    public int add(User user) {
        String sql = "INSERT INTO user (name,user_no,user_type,password,is_delete) VALUES (?,?,?,?,0)";
        List<Object> param = new ArrayList<>();
        param.add(user.getName());
        param.add(user.getUserNo());
        param.add(user.getUserType());
        param.add(user.getPassword());
        return CRUDTemplate.executeUpdate(sql, param);
    }

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return int
     */
    @Override
    public int update(User user) {
        String sql = "UPDATE user set name = ?,user_no = ?,user_type = ?, password = ? WHERE id = ?";
        List<Object> param = new ArrayList<>();
        param.add(user.getName());
        param.add(user.getUserNo());
        param.add(user.getUserType());
        param.add(user.getPassword());
        param.add(user.getId());
        return CRUDTemplate.executeUpdate(sql, param);
    }

    @Override
    public int delete(Long id) {
        String sql = "UPDATE user set is_delete = 1, password WHERE id = ?";
        List<Object> param = new ArrayList<>();
        param.add(id);
        return CRUDTemplate.executeUpdate(sql, param);
    }

    /**
     * 根据主键id删除用户
     *
     * @param id 主键id
     * @return int
     */
    @Override
    public User getByName(String name) {
        String sql = SELECT_COLUMNS + "  where name = ?";
        List<Object> param = new ArrayList<>();
        param.add(name);
        return CRUDTemplate.executeQuery(sql, new BeanHandler<>(User.class), param);
    }

    /**
     * 根据用户名查询用户实体类
     *
     * @param name 用户名
     * @return User
     */
    @Override
    public List<User> queryList(UserQuery query) {
        String sql = SELECT_COLUMNS + "  where  1=1 ";

        List<Object> param = new ArrayList<>();
        setParam(sql, param, query);

        if (query.getOrderBy() != null && query.getOrderBy().trim().length() > 0) {
            sql = sql + " order by " + query.getOrderBy();
        }
        return CRUDTemplate.executeQuery(sql, new BeanListHandler<>(User.class), param);
    }

    /**
     * 根据查询条件分页用户实体类集合
     *
     * @param query 主键id
     * @return List<User>
     */
    @Override
    public List<User> queryListByPage(UserQuery query) {
        String sql = SELECT_COLUMNS + "  where  1=1 ";
        List<Object> param = new ArrayList<>();
        setParam(sql, param, query);
        sql = sql + " limit " + query.getLimit() + ", offset " + query.getOffset();

        if (query.getOrderBy() != null && query.getOrderBy().trim().length() > 0) {
            sql = sql + " order by " + query.getOrderBy();
        }
        return CRUDTemplate.executeQuery(sql, new BeanListHandler<>(User.class), param);
    }

    /**
     * 根据查询条件分页用户实总条数
     *
     * @param query 主键id
     * @return Integer
     */
    @Override
    public Integer queryPageCount(UserQuery query) {
        String sql = SELECT_COLUMNS + "  where  1=1 ";
        List<Object> param = new ArrayList<>();
        setParam(sql, param, query);
        sql = sql + " limit " + query.getLimit() + ", offset " + query.getOffset();
        return CRUDTemplate.executeQuery(sql, new BeanHandler<>(Integer.class), param);
    }

    /**
     * 配置参数
     *
     * @param sql   sql
     * @param param 参数列表
     * @param query 查询条件
     */
    private void setParam(String sql, List<Object> param, UserQuery query) {
        if (query.getName() != null && query.getName().trim().length() > 0) {
            sql = sql + " and name = ?";
            param.add(query.getName());
        }
        if (query.getUserNo() != null && query.getName().trim().length() > 0) {
            sql = sql + " and user_no = ?";
            param.add(query.getUserNo());
        }
        if (query.getUserNo() != null && query.getName().trim().length() > 0) {
            sql = sql + " and user_no = ?";
            param.add(query.getUserNo());
        }
    }
}
