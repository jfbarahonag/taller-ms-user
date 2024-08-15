package com.ms.user.service;

import org.springframework.http.ResponseEntity;

import com.ms.user.model.UserEntity;

public interface UserService {

    ResponseEntity<UserEntity> create(UserEntity userEntity);
}
