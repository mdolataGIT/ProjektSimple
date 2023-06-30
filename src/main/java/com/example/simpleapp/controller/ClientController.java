package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Client;
import com.example.simpleapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public Iterable<Client> getAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.findClientById(id);
    }


    @GetMapping("/{name}/{surname}")
    public Client getClientByNameAndSurname(@PathVariable String name, @PathVariable String surname){
        return clientService.findClientByNameAndSurname(name,surname);
    }

    @PostMapping
    public ResponseEntity<?> createNewClient(@Valid @RequestBody Client client){
        return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient (@PathVariable Long id){
        clientService.deleteClientById(id);
        return new ResponseEntity<>("Client with Id: '"+id+ "' was deleted", HttpStatus.OK);
    }
}
