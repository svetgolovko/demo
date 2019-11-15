package com.example.demo.repo;
import java.util.List;

import com.example.demo.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByLastName(String lastName);

    //Client findById(long id);
}