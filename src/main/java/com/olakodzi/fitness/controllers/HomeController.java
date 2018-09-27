package com.olakodzi.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showPage() {
        return "/view/main-menu.jsp";
    }



}