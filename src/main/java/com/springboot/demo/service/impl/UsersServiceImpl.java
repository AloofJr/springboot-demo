package com.springboot.demo.service.impl;

import com.springboot.demo.repository.dao.UsersMapper;
import com.springboot.demo.repository.po.Users;
import com.springboot.demo.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aloofJr
 * @date 2019/3/30
 */
@Service("userService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper userDao;

    @Override
    public Users getUserById(long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addUser(Users users) {
        boolean result = false;
        try {
            userDao.insertSelective(users);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Transactional
    @Override
    public List<Users> getUserByCondition(Users users) {
        return userDao.selectByCondition(users);
    }
}
