package com.example.Job_Portal.Controller;

import com.example.Job_Portal.Dto.ContactRequestDto;
import com.example.Job_Portal.Model.Contact;
import com.example.Job_Portal.Service.impl.ContactServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
@Slf4j
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContact(@RequestBody ContactRequestDto contactRequestDto) {
        log.info("Received contact request: {}", contactRequestDto);
        boolean isaved = contactService.saveContact(contactRequestDto);

        if (isaved) {
            return ResponseEntity.ok("Contact saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");
        }
    }
}
