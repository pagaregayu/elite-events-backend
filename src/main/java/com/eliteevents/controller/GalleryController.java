package com.eliteevents.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eliteevents.entity.Gallery;
import com.eliteevents.service.GalleryService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin("*")
public class GalleryController {

    @Autowired
    private GalleryService service;

    private final String UPLOAD_DIR =
            System.getProperty("user.dir")
                    + "/uploads/gallery/";

    @PostMapping("/upload")
    public Gallery uploadGallery(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("file") MultipartFile file)
            throws IOException {

        File directory = new File(UPLOAD_DIR);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName =
                System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

        File destination =
                new File(UPLOAD_DIR + fileName);

        file.transferTo(destination);

        Gallery gallery =
                new Gallery();

        gallery.setTitle(title);
        gallery.setCategory(category);

        gallery.setMediaUrl(
                "http://localhost:8080/uploads/gallery/"
                        + fileName);

        gallery.setMediaType(
                file.getContentType());

        return service.saveGallery(gallery);
    }

    @GetMapping
    public List<Gallery> getAllGallery() {

        return service.getAllGallery();

    }

    @DeleteMapping("/{id}")
    public void deleteGallery(
            @PathVariable Long id) {

        service.deleteGallery(id);

    }
}