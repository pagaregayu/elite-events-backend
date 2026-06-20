package com.eliteevents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eliteevents.entity.Admin;
import com.eliteevents.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminRepository repository;

    @PostMapping("/login")
    public String login(
            @RequestBody Admin admin) {

        Admin existing =
                repository.findByEmail(admin.getEmail());

        if (existing != null &&
            existing.getPassword()
                    .equals(admin.getPassword())) {

            return "Login Successful";
        }

        return "Invalid Credentials";
    }
}