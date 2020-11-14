package com.examination_system.dao.base;

import com.examination_system.utils.LogUtil;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program examination-system
 * @description: 实体类集合返回处理
 * @author: yao
 * @create: 2020/11/14 12:51
 */
public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    private static final Logger LOGGER = LogUtil.getLogger();

    private Class<T> clazz;

    public BeanListHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 利用反射原理,将Jdbc的返回结果处理成实体类集合
     *
     * @param rs Jdbc的返回结果
     * @return T
     */
    @Override
    public List<T> handle(ResultSet rs) {
        try {
            //获取指定字节码信息
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
            //获取所有属性描述器
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                T obj = clazz.newInstance();
                for (PropertyDescriptor pd : pds) {
                    //获取结果集中对应字段名的值
                    Object o = rs.getObject(pd.getName());
                    //执行当前方法并传入参数
                    pd.getWriteMethod().invoke(obj, o);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            LOGGER.info("BeanListHandler|handle error: " + e.getMessage());
            return null;
        }
    }
}

