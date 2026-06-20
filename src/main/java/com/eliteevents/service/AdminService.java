package com.eliteevents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.Admin;
import com.eliteevents.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin login(String email) {
        return repository.findByEmail(email);
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }
}