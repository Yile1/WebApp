package pers.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行：Insert、Update、Delete语句
     * @param sql
     * @param args
     * @return 返回-1则执行失败，否则返回受影响的行数
     */
    public int update(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个javabean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            //返回type
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个javabean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public<T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    public List<Object[]> queryForArray(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
