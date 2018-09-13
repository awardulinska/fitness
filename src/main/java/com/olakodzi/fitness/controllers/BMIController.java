package com.olakodzi.fitness.controllers;

import com.olakodzi.fitness.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BMI")
public class BMIController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel){

        Client theClient = new Client();
        theModel.addAttribute("client", theClient);

        return "/view/BMI-form.jsp";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("client") Client theClient) {

        return "/view/BMI-confirmation.jsp";
    }
}
