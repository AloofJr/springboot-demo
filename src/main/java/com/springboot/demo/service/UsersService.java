package com.springboot.demo.service;

import com.springboot.demo.repository.po.Users;

import java.util.List;

/**
 * @author aloofJr
 * @date 2019/3/30
 */
public interface UsersService {
    Users getUserById(long id);

    boolean addUser(Users users);

    List<Users> getUserByCondition(Users users);
}
