package com.redhat.serverless.serverlessdemo.repository;



import com.redhat.serverless.serverlessdemo.model.contactdm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<contactdm, Long>
{
    
        
}

