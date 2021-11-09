package com.example.practice5springrestmvc.controllers;

import com.example.practice5springrestmvc.aop.RestLog;
import com.example.practice5springrestmvc.entity.Client;
import com.example.practice5springrestmvc.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    Logger log = LoggerFactory.getLogger(ProductController.class);


    @RestLog(uri = "http://localhost:8080/clients")
    @GetMapping()
    public List<Client> getClients(HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());
        return clientService.findAll();
    }

    @RestLog(uri = "http://localhost:8080/clients/{id}")
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id, HttpServletRequest request) {
        return clientService.findById(id);
    }

    @RestLog(uri = "http://localhost:8080/clients")
    @PostMapping
    public Client createNewClient(@RequestBody Client client, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());

        return clientService.createClient(client);
    }

    @RestLog(uri = "http://localhost:8080/clients/{id}")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());

        return clientService.delete(id);
    }
}
