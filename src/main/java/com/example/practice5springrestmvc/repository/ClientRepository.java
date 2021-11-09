package com.example.practice5springrestmvc.repository;

import com.example.practice5springrestmvc.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
