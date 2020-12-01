package com.examination_system.dao.base;

import java.sql.*;

/**
 * JDBC工具类
 *
 * @author xueli.yao 2020-11-14
 */
public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，在程序编译的时候执行
    static {
        try {
            //获取数据库连接驱动名字
            driver = "com.mysql.jdbc.Driver";
            //获取数据库连接地址
            url = "jdbc:mysql://localhost:3306/com.examination_system.examination_system?useSSL=false&characterEncoding=utf-8";
            //获取数据库连接用户名
            username = "root";
            //获取数据库连接密码
            password = "mysqlroot";
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return Connection连接对象
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接（Connection连接对象必须在最后关闭）
     * @param conn Connection连接对象
     * @param st 编译执行对象
     * @param rs 结果集
     */
    public static void close(Connection conn, Statement st, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
