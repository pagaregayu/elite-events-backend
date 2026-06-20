package com.eliteevents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliteevents.entity.Gallery;
import com.eliteevents.repository.GalleryRepository;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository repository;

    public Gallery saveGallery(
            Gallery gallery) {

        return repository.save(gallery);

    }

    public List<Gallery> getAllGallery() {

        return repository.findAll();

    }

    public void deleteGallery(Long id) {

        repository.deleteById(id);

    }
}