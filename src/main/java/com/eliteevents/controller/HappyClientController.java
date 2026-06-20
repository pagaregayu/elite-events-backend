package com.eliteevents.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eliteevents.entity.HappyClient;
import com.eliteevents.service.CloudinaryService;
import com.eliteevents.service.HappyClientService;

@RestController
@RequestMapping("/api/happy-clients")
@CrossOrigin("*")
public class HappyClientController {

    @Autowired
    private HappyClientService service;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public HappyClient uploadClient(
            @RequestParam("clientName") String clientName,
            @RequestParam("eventName") String eventName,
            @RequestParam(value = "eventType", required = false) String eventType,
            @RequestParam(value = "rating", required = false) Integer rating,
            @RequestParam(value = "review", required = false) String review,
            @RequestParam(value = "file1", required = false) MultipartFile file1,
            @RequestParam(value = "file2", required = false) MultipartFile file2,
            @RequestParam(value = "file3", required = false) MultipartFile file3,
            @RequestParam(value = "file4", required = false) MultipartFile file4)
            throws IOException {

        HappyClient client = new HappyClient();

        client.setClientName(clientName);
        client.setEventName(eventName);
        client.setEventType(eventType);
        client.setRating(rating != null ? rating : 5);
        client.setReview(review);

        if (file1 != null && !file1.isEmpty()) {
            client.setMediaUrl1(
                    cloudinaryService.uploadFile(file1));
            client.setMediaType1(
                    file1.getContentType());
        }

        if (file2 != null && !file2.isEmpty()) {
            client.setMediaUrl2(
                    cloudinaryService.uploadFile(file2));
            client.setMediaType2(
                    file2.getContentType());
        }

        if (file3 != null && !file3.isEmpty()) {
            client.setMediaUrl3(
                    cloudinaryService.uploadFile(file3));
            client.setMediaType3(
                    file3.getContentType());
        }

        if (file4 != null && !file4.isEmpty()) {
            client.setMediaUrl4(
                    cloudinaryService.uploadFile(file4));
            client.setMediaType4(
                    file4.getContentType());
        }

        return service.saveClient(client);
    }

    @GetMapping
    public List<HappyClient> getAllClients() {
        return service.getAllClients();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
    }
}