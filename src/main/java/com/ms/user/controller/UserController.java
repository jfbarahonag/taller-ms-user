package com.ms.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.controller.docs.UserDoc;
import com.ms.user.model.UserEntity;
import com.ms.user.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UserController implements UserDoc {
    
    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }
}
