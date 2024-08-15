package com.ms.user.service;

import java.util.Optional;

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
    
    @Override
    public ResponseEntity<UserEntity> getById(String id) {
        try {
            Optional<UserEntity> user = userRepository.findById(id);

            if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(user.get());
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }
    
    @Override
    public ResponseEntity<UserEntity> deleteById(String id) {
        try {
            Optional<UserEntity> user = userRepository.findById(id);

            if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            userRepository.delete(user.get());

            return ResponseEntity.ok(user.get());
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

}
