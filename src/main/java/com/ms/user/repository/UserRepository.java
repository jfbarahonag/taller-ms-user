package com.ms.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
