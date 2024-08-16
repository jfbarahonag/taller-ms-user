package com.ms.user.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.user.dto.UserDto;
import com.ms.user.exception.BusinessException;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserDto userDto) {

        var user = userRepository.findByDocumentAndDocumentType(userDto.document(), userDto.documentType());

        if (user.isPresent()) {
            throw new BusinessException("User has been registered previously");
        }
        
        UserEntity userEntity = UserEntity
                .builder()
                .id(UUID.randomUUID().toString())
                .name(userDto.name())
                .document(userDto.document())
                .documentType(userDto.documentType())
                .build();

        UserEntity newUser = userRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
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
    
    @Override
    public ResponseEntity<UserEntity> updateById(String id, UserDto userDto) {
        try {
            Optional<UserEntity> user = userRepository.findById(id);

            if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
}
            
            UserEntity userEntity = UserEntity
                    .builder()
                    .id(id)
                    .name(userDto.name())
                    .document(userDto.document())
                    .documentType(userDto.documentType())
                    .build();

            userRepository.save(userEntity);

            return ResponseEntity.ok(userEntity);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

}
