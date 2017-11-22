package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ville on 2017/3/1.
 * 数据库连接工具类
 */
public class JDBCUtil {

    /**
     * 数据源
     */
    private static final DataSource dataSource = new ComboPooledDataSource();
    /**
     * 局部变量存放事务连接
     */
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     * 获取单例数据源
     *
     * @return Unique DataSource Object
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 若已开启事务，则返回当前事务连接
     * 若未开启事务，则返回从连接池中返回一个非事务连接
     *
     * @return a Connection
     */
    public static Connection getConnection() throws SQLException {
        //获取当前线程的事务连接get current transactional connection
        Connection con = threadLocal.get();
        if (null == con) {
            //set a non-transactional connection
            con = dataSource.getConnection();
        }
        return con;
    }

    /**
     * 开启事务，设置事务连接
     *
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        //获取当前线程的事务连接
        Connection con = threadLocal.get();
        if (null != con) {
            throw new SQLException("已经开启了事务，不能重复开启！");
        }
        //给con赋值，表示开启了事务
        con = dataSource.getConnection();
        //设置为手动提交
        con.setAutoCommit(false);
        //把当前事务连接放到threadLocal中
        threadLocal.set(con);
    }

    /**
     * 提交，并释放连接，结束事务
     *
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        //获取当前线程的事务连接
        Connection con = threadLocal.get();
        if (null == con) {
            throw new SQLException("未开启事务，不能提交！");
        }
        //提交
        con.commit();
        //释放连接到连接池
        con.close();
        //结束事务
        threadLocal.remove();
    }

    /**
     * 回滚，并释放连接，结束事务
     *
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        //获取当前线程的事务连接
        Connection con = threadLocal.get();
        if (con == null) {
            throw new SQLException("未开启事务，不能回滚！");
        }
        //回滚
        con.rollback();
        //释放连接到连接池
        con.close();
        //结束事务
        threadLocal.remove();
    }

    /**
     * 释放事务连接
     */
    public static void releaseConnection() throws SQLException {
        //获取当前线程的事务连接
        Connection con = threadLocal.get();
        if (null != con) {
            //释放连接到连接池
            con.close();
            //结束事务
            threadLocal.remove();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
