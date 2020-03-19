package com.kgisl.raja.onlineportal.service;

import com.kgisl.raja.onlineportal.model.User;
import java.util.List;

/**
 * UserDao
 */
public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUserById(Long id);
    public void deleteAllUsers();
}