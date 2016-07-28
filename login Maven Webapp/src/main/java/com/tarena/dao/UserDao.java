package com.tarena.dao;

import org.springframework.stereotype.Repository;

import com.tarena.bean.User;

@Repository(value="userDao")
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUser(User user);
}