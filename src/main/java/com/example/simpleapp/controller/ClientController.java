package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Client;
import com.example.simpleapp.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Iterable<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.findClientById(id);
    }

    @GetMapping("/{name}/{surname}")
    public List<Client> getClientByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return clientService.findClientByNameAndSurname(name, surname);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return new ResponseEntity<>("Client with Id: '" + id + "' was deleted", HttpStatus.OK);
    }

    @PatchMapping("/{id}/{age}")
    public ResponseEntity<?> updateClientAge(@PathVariable Long id, @PathVariable int age) {
        return new ResponseEntity<>(clientService.updateClientAge(id, age), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody Client client, @PathVariable Long id) {
        return new ResponseEntity<>(clientService.updateClient(client, id), HttpStatus.OK);
    }
}
