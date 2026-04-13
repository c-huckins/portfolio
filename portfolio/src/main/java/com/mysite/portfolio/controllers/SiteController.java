package com.mysite.portfolio.controllers;

import com.mysite.portfolio.models.AuthorizedUser;
import com.mysite.portfolio.repositories.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    @Autowired
    private AuthUserRepository userRepo;

    @GetMapping("/")
    public String getHomePage(Model model) {
        String message = "Welcome to my site.";
        model.addAttribute("message", message);
        return "home";
    }

    @GetMapping("/testLogin")
    public String getTestLogin(Model model) {
        return "testLogin";
    }

    @GetMapping("/testDB")
    public String getTestDB(Model model) {
        AuthorizedUser user = new AuthorizedUser();
        user.setId("1111111");
        user.setUserName("testUser");
        user.setPassword("1111");
        userRepo.save(user);
        return "testDB";
    }
}
