package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.Client;
import com.example.practice5springrestmvc.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBInitClient {

    @Autowired
    ClientRepository clientRepository;

    @PostConstruct
    public void initClientTable() {
        Client client = new Client();
        client.setClientName("Peter");
        client.setClientEmail("peter@gmail.com");

        clientRepository.save(client);

        Client client2 = new Client();
        client2.setClientName("Sara");
        client2.setClientEmail("sara@gmail.com");

        clientRepository.save(client2);



    }
}
