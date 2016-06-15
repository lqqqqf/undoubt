package com.lqqqqf.dao;


import com.lqqqqf.domain.pojo.User;
import org.springframework.data.repository.Repository;

/**
 * Created by apple on 16/5/8.
 */
public interface UserRepository extends Repository<User, Long> {

    User findByEmailOrUsername(String username);
}
