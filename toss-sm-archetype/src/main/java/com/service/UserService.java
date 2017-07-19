package com.service;

import com.pojo.User;

import java.util.List;

/**
 * Created by ville on 2017/7/18.
 */
public interface UserService {

    int saveUser(User role);

    int removeUser(Integer id);

    int updateUser(User role);

    User getUser(Integer id);

    List<User> listUsers(int pageNo, int pageSize);
}
