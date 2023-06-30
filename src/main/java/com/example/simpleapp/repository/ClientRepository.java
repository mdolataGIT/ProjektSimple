package com.example.simpleapp.repository;

import com.example.simpleapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    Iterable<Client> findAll();

    Client findClientById(Long id);

    List<Client> findByNameAndSurname(String name, String surname);

}
