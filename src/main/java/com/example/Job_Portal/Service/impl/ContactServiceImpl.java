package com.example.Job_Portal.Service.impl;

import com.example.Job_Portal.Dto.ContactRequestDto;
import com.example.Job_Portal.Model.Contact;
import com.example.Job_Portal.Repository.ContantRepository;
import com.example.Job_Portal.Service.IcontactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Service
public class ContactServiceImpl implements IcontactService {

    @Autowired
    private ContantRepository contactRepository;



     @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
         boolean result=false;

         Contact contact= contactRepository.save(transform(contactRequestDto));
          if(contact!=null && contact.getId()!=null){
              result=true;
          }
         return result;
    }

    private Contact transform(ContactRequestDto contactRequestDto){
        Contact contact =new Contact();
        BeanUtils.copyProperties(contactRequestDto,contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }
}
