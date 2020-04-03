package com.lyn.mapper;

import com.lyn.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    int insert(User user);


}
