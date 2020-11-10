package com.redhat.serverless.serverlessdemo.service;

import com.redhat.serverless.serverlessdemo.repository.ContactRepository;


import com.redhat.serverless.serverlessdemo.model.contactdm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsService {

    @Autowired
    ContactRepository contactsrepo;

    public void addContact(contactdm contact)
    {
        contactsrepo.save(contact);
    }
    
}