package com.lqqqqf.dao;


import com.lqqqqf.domain.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by apple on 16/5/8.
 */
public interface UserRepository extends Repository<User, Long> {

    @Query("FROM #{#entityName} e WHERE e.username=?1 OR e.email=?1")
    User findByEmailOrUsername(String username);
}
