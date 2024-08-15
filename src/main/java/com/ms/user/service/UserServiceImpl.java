package com.ms.user.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.user.model.UserEntity;
import com.ms.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserEntity userEntity) {
        try {
            UserEntity newUser = userRepository.save(userEntity);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

}
