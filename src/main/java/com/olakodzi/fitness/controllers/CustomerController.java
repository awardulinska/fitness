package com.olakodzi.fitness.controllers;

import com.olakodzi.fitness.Client;
import com.olakodzi.fitness.exception.ResourceNotFoundException;
import com.olakodzi.fitness.repository.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    FitnessRepository fitnessRepository;

    @GetMapping("/list")
    public String getAllClients(Model theModel){
        List<Client> clients =  fitnessRepository.findAll();

        theModel.addAttribute(  "clients", clients);
        Collections.sort(clients, Comparator.comparing(Client::getLastName));
        return "/view/list-customers.jsp";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Client customer = new Client();
        theModel.addAttribute("customer", customer);

        return "/view/customer-form.jsp";
    }

    @PostMapping("/saveCustomer")
    public String saveClient(@ModelAttribute("customer") Client client) {

        fitnessRepository.save(client);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Long theId, Model theModel){

        Client customer = fitnessRepository.getOne(theId);
        theModel.addAttribute("customer", customer);
        return "/view/customer-form.jsp";
    }

    @PutMapping("/updateCustomer")
    public String updateClient(@PathVariable(value = "id") Long clientId, @Valid @RequestBody Client clientDetails){

        Client customerToUpdate = fitnessRepository.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client", "id", clientId));
        customerToUpdate.setFirstName(clientDetails.getFirstName());
        customerToUpdate.setLastName(clientDetails.getLastName());
        customerToUpdate.setEmail(clientDetails.getEmail());
        customerToUpdate.setHeight(clientDetails.getHeight());
        customerToUpdate.setWeight(clientDetails.getWeight());

        fitnessRepository.save(customerToUpdate);
        return "redirect:/customer/list";
    }

}