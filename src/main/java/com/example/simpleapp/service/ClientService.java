package com.example.simpleapp.service;

import com.example.simpleapp.domain.Client;
import com.example.simpleapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Client> findClientByNameAndSurname(String name, String surname) {
        return clientRepository.findByNameAndSurname(name, surname);
    }

    public void deleteClientById(Long id) {
        clientRepository.delete(findClientById(id));
    }

    public Client updateClientAge(Long id, int age) {
        Client client = findClientById(id);
        client.setAge(age);

        return clientRepository.save(client);
    }

    public Client updateClient(Client client, Long id) {
        Client currentClient = clientRepository.findClientById(id);
        currentClient.setName(client.getName());
        currentClient.setSurname(client.getSurname());
        currentClient.setAge(client.getAge());

        return clientRepository.save(currentClient);
    }
}
