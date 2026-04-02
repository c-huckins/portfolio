package com.mysite.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String getHomePage(Model model) {
        String message = "Welcome to my site.";
        model.addAttribute("message", message);
        return "home";
    }
}
