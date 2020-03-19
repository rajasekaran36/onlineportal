package com.kgisl.raja.onlineportal.controller;

import java.util.List;

import com.kgisl.raja.onlineportal.model.User;
import com.kgisl.raja.onlineportal.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/get/all")
    public @ResponseBody ResponseEntity<List<User>> all(){
        return new ResponseEntity<List<User>>(userServiceImp.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<User> getById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<User>(userServiceImp.getUserById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<User>(userServiceImp.addUser(user),HttpStatus.CREATED);
    }
    @PutMapping(value = "/update",headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<User>(userServiceImp.updateUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody void deleteById(@PathVariable(value = "id") Long id){
        userServiceImp.deleteUserById(id);
    }

    @DeleteMapping("/delete/all")
    public @ResponseBody void deleteAll(){
        userServiceImp.deleteAllUsers();
    }
}