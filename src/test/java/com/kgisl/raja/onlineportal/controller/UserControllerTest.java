package com.kgisl.raja.onlineportal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.kgisl.raja.onlineportal.model.User;
import com.kgisl.raja.onlineportal.model.UserBuilder;
import com.kgisl.raja.onlineportal.repository.UserRepository;
import com.kgisl.raja.onlineportal.service.UserService;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * UserControllerTest
 */
@RunWith(MockitoJUnitRunner.class)
 public class UserControllerTest {
    @InjectMocks    
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    
    public static List<User> expectedUsers;

    private User user1 = new UserBuilder().id(100L).name("testname1").build();
    private User user2 = new UserBuilder().id(200L).name("testname2").build();

    @Test
    public void getAll(){
        expectedUsers = new ArrayList<User>();
        expectedUsers.add(user1);
        expectedUsers.add(user2);
        when(userService.getAllUsers()).thenReturn(expectedUsers);
        
        ResponseEntity<List<User>> actualUsers = userController.all(); 
        assertNotNull(actualUsers);
        assertEquals(HttpStatus.OK, actualUsers.getStatusCode());
    }

   /*  @Ignore
    public void getOne(){
        User expectedUser = user1;
        when(userService.getUserById(100L)).thenReturn(expectedUser);
        
        ResponseEntity<User> actualUser = userController.getById(100L); 
        assertNotNull(actualUser);
        assertEquals(HttpStatus.OK, actualUser.getStatusCode());
    } */
}