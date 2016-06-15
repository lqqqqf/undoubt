package com.lqqqqf.service.impl;

import com.lqqqqf.dao.UserRepository;
import com.lqqqqf.domain.pojo.User;
import com.lqqqqf.service.UserService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by apple on 16/6/15.
 */
@Named
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmailOrUsername(String username) {
        return userRepository.findByEmailOrUsername(username);
    }
}
