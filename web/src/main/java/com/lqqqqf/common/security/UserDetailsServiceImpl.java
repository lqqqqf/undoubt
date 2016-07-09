package com.lqqqqf.common.security;

import com.lqqqqf.domain.pojo.User;
import com.lqqqqf.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Inject
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmailOrUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not exists!!");
        }
        return user;
    }
}
