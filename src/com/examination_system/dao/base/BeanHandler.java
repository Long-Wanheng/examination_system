package com.examination_system.dao.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

/**
 * @program examination-system
 * @description: 实体类返回处理
 * @author: yao
 * @create: 2020/11/14 12:49
 */
public class BeanHandler<T> implements IResultSetHandler<T> {
    private Class<T> clazz;

    public BeanHandler(Class<T> clazz) {
        this.clazz = clazz;
    }


    /**
     * 利用反射原理,将Jdbc的返回结果处理成实体类
     *
     * @param rs Jdbc的返回结果
     * @return T
     */
    @Override
    public T handle(ResultSet rs) {
        try {
            //结果集默认指向为第一个数据的前一个
            if (rs.next()) {
                //根据传入的字节码创建传入的指定对象
                T obj = clazz.newInstance();
                //获取指定字节码信息
                BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
                //获取所有属性描述器
                PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    //获取结果集中对应字段名的值
                    Object o = rs.getObject(pd.getName());
                    //执行当前方法并传入参数
                    pd.getWriteMethod().invoke(obj, o);
                }
                return obj;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}