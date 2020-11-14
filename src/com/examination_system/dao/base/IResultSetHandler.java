package com.examination_system.dao.base;

import java.sql.ResultSet;

/**
 * @program examination-system
 * @description: 封装JDBC返回类型
 * @author: yao
 * @create: 2020/11/14 12:48
 */
public interface IResultSetHandler<T> {
    /**
     * 处理返回值类型
     *
     * @param rs JDBC-ResultSet
     * @return T
     */
    T handle(ResultSet rs);
}