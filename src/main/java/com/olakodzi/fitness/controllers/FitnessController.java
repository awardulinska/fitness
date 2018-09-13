package com.olakodzi.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fitness")
public class FitnessController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "/view/fitness.jsp";
    }
}

