package com.example.simpleapp.repository;

import com.example.simpleapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    Iterable<Client> findAll();

    @Override
    Optional<Client> findById(Long id);

    Client findByNameAndSurname(String name, String surname);

}
