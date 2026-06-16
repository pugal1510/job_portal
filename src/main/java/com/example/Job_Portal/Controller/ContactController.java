package com.example.Job_Portal.Controller;

import com.example.Job_Portal.Dto.ContactRequestDto;
import com.example.Job_Portal.Model.Contact;
import com.example.Job_Portal.Service.impl.ContactServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jshell.Snippet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@Slf4j
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContact(@RequestBody @Valid  ContactRequestDto contactRequestDto) {
        log.info("Received contact request: {}", contactRequestDto);
        boolean isaved = contactService.saveContact(contactRequestDto);
        if (isaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");
        }
    }

    @GetMapping
    public ResponseEntity<String>fetchOpenContacts(@RequestParam @Validated @NotBlank(message = "should not be blank") String status){
        return ResponseEntity.ok("Fetching contacts with status: "+status);
    }
}
