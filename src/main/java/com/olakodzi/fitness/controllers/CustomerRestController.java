package com.olakodzi.fitness.controllers;

import com.olakodzi.fitness.Client;
import com.olakodzi.fitness.exception.ResourceNotFoundException;
import com.olakodzi.fitness.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    FitnessRepository fitnessRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return fitnessRepository.findAll();
    }

    @PostMapping("/clients")
    public Client newClient(@Valid @RequestBody Client client) {

        return fitnessRepository.save(client);
    }

    @GetMapping("/clients/{id}")
    public Client getClientById (@PathVariable(value = "id") Long clientId){
        return fitnessRepository.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client", "id", clientId));
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable(value = "id") Long clientId, @Valid @RequestBody Client clientDetails){

        Client client = fitnessRepository.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client", "id", clientId));
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setHeight(clientDetails.getHeight());
        client.setWeight(clientDetails.getWeight());

        Client updatedClient = fitnessRepository.save(client);
        return updatedClient;
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable (value = "id") Long clientId){
        Client client = fitnessRepository.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client", "id", clientId));

        fitnessRepository.delete(client);

        return ResponseEntity.ok().build();
    }
}