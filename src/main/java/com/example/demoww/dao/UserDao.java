package com.example.demoww.dao;

import com.example.demoww.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Long> {
    public UserEntity findByUsernameAndPassword(String username,String password);
    UserEntity findByUsername(String username);
    UserEntity findById(long id);
}
