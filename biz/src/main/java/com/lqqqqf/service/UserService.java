package com.lqqqqf.service;

import com.lqqqqf.domain.pojo.User;

/**
 * Created by apple on 16/6/15.
 */
public interface UserService {

    User getByEmailOrUsername(String username);
}
