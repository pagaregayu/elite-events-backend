package com.eliteevents.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eliteevents.entity.Gallery;
import com.eliteevents.service.CloudinaryService;
import com.eliteevents.service.GalleryService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin("*")
public class GalleryController {

    @Autowired
    private GalleryService service;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public Gallery uploadGallery(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("file") MultipartFile file)
            throws IOException {

        String imageUrl =
                cloudinaryService.uploadFile(file);

        Gallery gallery = new Gallery();

        gallery.setTitle(title);
        gallery.setCategory(category);
        gallery.setMediaUrl(imageUrl);
        gallery.setMediaType(file.getContentType());

        return service.saveGallery(gallery);
    }

    @GetMapping
    public List<Gallery> getAllGallery() {
        return service.getAllGallery();
    }

    @DeleteMapping("/{id}")
    public void deleteGallery(@PathVariable Long id) {
        service.deleteGallery(id);
    }
}