package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Client;
import com.example.demo.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {

        return (List<Client>) repository.findAll();
    }

    @PostMapping(value = "/clients")
    void addClient(@RequestBody Client client) {
         Client _client = repository.save(client);
    }

    @GetMapping("/clients/{id}")
    public  Optional<Client> getClient(@PathVariable("id") long id) {
        Optional<Client> clientData = repository.findById(id);
        return clientData;
    }

    @PostMapping(value = "/clients/create")
    public Client postCustomer(@RequestBody Client client) {
        Client _client = repository.save(new Client(client.getSecurityNumber(), client.getFirstName(), client.getLastName()));
        return _client;
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") long id) {
        System.out.println("Delete Client with ID = " + id + "...");
        repository.deleteById(id);
        return new ResponseEntity<>("Client has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/clients/delete")
    public ResponseEntity<String> deleteAllClients() {
        System.out.println("Delete All Clients...");
        repository.deleteAll();
        return new ResponseEntity<>("All clients have been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "clients/age/{lastName}")
    public List<Client> findByAge(@PathVariable String lastName) {
        List<Client> clients = repository.findByLastName(lastName);
        return clients;
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        System.out.println("Update Client with ID = " + id + "...");

        Optional<Client> clientData = repository.findById(id);
        //Client clientData = repository.findById(id);

        if (clientData.isPresent()) {
            Client _customer = clientData.get();
            _customer.setFirstName(client.getFirstName());
            _customer.setLastName(client.getLastName());
            _customer.setPhone(client.getPhone());
            _customer.setAddress(client.getAddress());
            return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}