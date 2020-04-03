package com.lyn.mapper;

import com.lyn.constant.YesNoEnum;
import com.lyn.entity.User;
import com.lyn.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        user.setId(2);
        user.setName("张三");
        user.setPwd("123456");
        user.setEnable(YesNoEnum.NO);
        int insert = mapper.insert(user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }
}