package com.eliteevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliteevents.entity.Gallery;

public interface GalleryRepository
        extends JpaRepository<Gallery, Long> {

}