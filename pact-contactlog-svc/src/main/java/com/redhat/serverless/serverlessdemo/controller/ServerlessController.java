package com.redhat.serverless.serverlessdemo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;


import com.redhat.serverless.serverlessdemo.model.contactdm;
import com.redhat.serverless.serverlessdemo.service.ContactsService;

@RestController
public class ServerlessController {

    @Autowired
    ContactsService cs;

    @PostMapping(path = "/", produces = "text/plain; charset=UTF-8")
    public void rootCall(@RequestBody String contactentry)
    {
        saveContact(contactentry);
    }

    
    @PostMapping(path = "/logcontact", consumes = "text/plain", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String saveContact(@RequestBody String contactentry)
    {

        String[] contactlist = contactentry.split(",");
        contactdm ct = new contactdm();
        ct.setMmid1(Integer.parseInt(contactlist[0]));
        ct.setMmid2(Integer.parseInt(contactlist[1]));
        ct.setStreet(contactlist[2]);
        ct.setCity(contactlist[3]);
        ct.setState(contactlist[4]);
        ct.setZipcode(contactlist[5]);
        ct.setCountry(contactlist[6]);
        cs.addContact(ct);
        return ct.getCity();

    }

}
