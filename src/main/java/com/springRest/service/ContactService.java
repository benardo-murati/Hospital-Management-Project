package com.springRest.service;

import com.springRest.DTO.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService
{
    @Autowired
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }
    public void save(Contact contact)
    {
        contactRepository.save(contact);
    }

}
