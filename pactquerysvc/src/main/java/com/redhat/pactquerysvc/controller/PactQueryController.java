package com.redhat.pactquerysvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.redhat.pactquerysvc.model.ContactDM;
import com.redhat.pactquerysvc.service.PactQueryService;

@RestController
public class PactQueryController {

    @Autowired
    PactQueryService pqs;

    @GetMapping(path = "/", produces = "text/plain")
    @ResponseBody
    public String rootCall()
    {
        return "Hellow World";
    }

    @GetMapping(path = "/findcontactbystate", consumes = "text/plain", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ContactDM> findByState(@RequestParam("state") String state)
    {
        return pqs.findContactByState(state);
    }

    @GetMapping(path = "/findcontactbycountry", consumes = "text/plain", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ContactDM>findByCountry(@RequestParam("country") String country)
    {
        return pqs.findContactByCountry(country);
    }
    
}