package com.redhat.pactquerysvc.repository;

import java.util.List;

import com.redhat.pactquerysvc.model.ContactDM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactDM, Long>
{
    
    //Interface for finding contact events by state
    public List<ContactDM> findContactByState(String state);
    //Interface for finding contact events by country
    public List<ContactDM> findContactByCountry(String country);
        
}