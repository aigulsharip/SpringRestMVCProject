package com.example.practice5springrestmvc.repository;

import com.example.practice5springrestmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
