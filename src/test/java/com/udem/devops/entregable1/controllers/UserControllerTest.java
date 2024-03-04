package com.udem.devops.entregable1.controllers;

import com.udem.devops.entregable1.entities.UserEntity;
import com.udem.devops.entregable1.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        List<UserEntity> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<UserEntity>> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users, response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        UserEntity user = new UserEntity();
        String id = "1";

        when(userService.getUserById(id)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.getUserById(Long.parseLong(id));

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUserById(id);
    }

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity();

        when(userService.createUser(user)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.createUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    public void testUpdateUser() {
        UserEntity user = new UserEntity();
        String id = "1";

        when(userService.updateUser(Long.parseLong(id), user)).thenReturn(user);

        ResponseEntity<UserEntity> response = userController.updateUser(Long.parseLong(id), user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).updateUser(Long.parseLong(id), user);
    }

    @Test
    public void testDeleteUser() {
        String id = "1";

        ResponseEntity<Void> response = userController.deleteUser(Long.parseLong(id));

        assertEquals(200, response.getStatusCodeValue());
        verify(userService, times(1)).deleteUser(id);
    }
}
