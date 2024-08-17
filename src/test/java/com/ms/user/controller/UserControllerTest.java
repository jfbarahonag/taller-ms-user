package com.ms.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.UserService;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testCreateUser() {

        //Arrange
        String name = "Pepe Piolas";
        String doc = "1234";
        String docType = "CC";
        
        UserDto userDto = UserDto
                .builder()
                .name(name)
                .document(doc)
                .documentType(docType)
                .build();
        
        UserEntity userEntity = UserEntity
                .builder()
                .id("some id")
                .name(name)
                .document(doc)
                .documentType(docType)
                .build();

        when(userService.create(any())).thenReturn(ResponseEntity.ok(userEntity));
        
        //Act
        var response = userController.createUser(userDto);

        //Assert
        assertNotNull(response);

        assertEquals(400, response.getStatusCode());

    }

    @Test
    void testDeleteUser() {

    }

    @Test
    void testGetUser() {

    }

    @Test
    void testUpdateUser() {

    }
}
