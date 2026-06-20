package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.HappyClient;
import com.eliteevents.repository.HappyClientRepository;

@Service
public class HappyClientService {

    @Autowired
    private HappyClientRepository repository;

    public HappyClient saveClient(HappyClient client) {
        return repository.save(client);
    }

    public List<HappyClient> getAllClients() {
        return repository.findAll();
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}