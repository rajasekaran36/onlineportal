package com.kgisl.raja.onlineportal.model;

/**
 * UserBuilder
 */
public class UserBuilder {
    private User user = new User();

    public UserBuilder id(Long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    public User build(){
        return user;
    }
}