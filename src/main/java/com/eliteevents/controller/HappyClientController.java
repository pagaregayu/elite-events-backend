package com.eliteevents.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eliteevents.entity.HappyClient;
import com.eliteevents.service.HappyClientService;

@RestController
@RequestMapping("/api/happy-clients")
@CrossOrigin("*")
public class HappyClientController {

    @Autowired
    private HappyClientService service;

    private final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/happyclients/";

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

        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) directory.mkdirs();

        HappyClient client = new HappyClient();
        client.setClientName(clientName);
        client.setEventName(eventName);
        client.setEventType(eventType);
        client.setRating(rating != null ? rating : 5);
        client.setReview(review);

        if (file1 != null && !file1.isEmpty()) {
            String name = saveFile(file1);
            client.setMediaUrl1("http://localhost:8080/uploads/happyclients/" + name);
            client.setMediaType1(file1.getContentType());
        }
        if (file2 != null && !file2.isEmpty()) {
            String name = saveFile(file2);
            client.setMediaUrl2("http://localhost:8080/uploads/happyclients/" + name);
            client.setMediaType2(file2.getContentType());
        }
        if (file3 != null && !file3.isEmpty()) {
            String name = saveFile(file3);
            client.setMediaUrl3("http://localhost:8080/uploads/happyclients/" + name);
            client.setMediaType3(file3.getContentType());
        }
        if (file4 != null && !file4.isEmpty()) {
            String name = saveFile(file4);
            client.setMediaUrl4("http://localhost:8080/uploads/happyclients/" + name);
            client.setMediaType4(file4.getContentType());
        }

        return service.saveClient(client);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        file.transferTo(new File(UPLOAD_DIR + fileName));
        return fileName;
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