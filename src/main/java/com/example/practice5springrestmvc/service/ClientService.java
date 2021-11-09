package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.Client;
import com.example.practice5springrestmvc.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }


    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public String delete(Long id) {
        clientRepository.deleteById(id);
        return "Client got deleted";
    }

}
