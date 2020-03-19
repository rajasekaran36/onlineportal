package com.kgisl.raja.onlineportal.service;

import java.util.List;

import com.kgisl.raja.onlineportal.model.User;
import com.kgisl.raja.onlineportal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserDaoImplService
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {     
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User xUser = getUserById(user.getId());
        xUser.setName(user.getName());
        return userRepository.save(xUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);;
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}