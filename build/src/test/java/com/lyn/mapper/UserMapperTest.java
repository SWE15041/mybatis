package com.lyn.mapper;

import com.lyn.entity.User;
import com.lyn.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserMapperTest {

    @Test
    public void selectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void insert() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setName("张三");
        user.setPwd("123456");
        int insert = mapper.insert(user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
            String username = "lanyn";
            String password = "123456";

            Connection connection = DriverManager.getConnection(url, username, password);
//            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            System.out.println(statement.isClosed());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}