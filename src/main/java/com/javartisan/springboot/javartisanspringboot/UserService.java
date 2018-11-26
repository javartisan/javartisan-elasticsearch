package com.javartisan.springboot.javartisanspringboot;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public void insert(User user) {
        userDao.index(user);
    }


    public User getUser(Long id) {
        return userDao.findOne(id);
    }
}
