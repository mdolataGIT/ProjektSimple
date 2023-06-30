package com.example.simpleapp.service;

import com.example.simpleapp.domain.Client;
import com.example.simpleapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    public Client findClientByNameAndSurname(String name, String surname) {
        return clientRepository.findByNameAndSurname(name,surname);
    }

    public void deleteClientById(Long id) {
        clientRepository.delete(findClientById(id));
    }
}
