package com.example.springrestmvc.repository;

import com.example.springrestmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
