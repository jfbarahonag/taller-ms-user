package com.ms.user.service;

import org.springframework.http.ResponseEntity;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;

public interface UserService {

    ResponseEntity<UserEntity> create(UserDto userDto);
    ResponseEntity<UserEntity> getById(String id);
    ResponseEntity<UserEntity> deleteById(String id);
    ResponseEntity<UserEntity> updateById(String id, UserDto userDto);
}
