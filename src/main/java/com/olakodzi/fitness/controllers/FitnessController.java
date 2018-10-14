package com.olakodzi.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fitness")
public class FitnessController {


    @RequestMapping("/showForm")
    public String showForm(){
        return "/view/fitness.jsp";
    }
}

