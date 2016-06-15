package com.lqqqqf.domain.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by apple on 16/6/13.
 */
@Entity
public class Role extends BaseEntity implements Serializable {

    private String name;

    private Set<Permission> authorities;

    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "role_permission",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "perm_id"))
    public Set<Permission> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Permission> authorities) {
        this.authorities = authorities;
    }

    @ManyToMany
    @JoinTable(name = "role_user",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
