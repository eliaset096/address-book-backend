package com.et.addressbook.repositories;

import com.et.addressbook.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends MongoRepository<Contact,String> {

    Contact findContactByFirstName(String firstName);
    Contact findContactByLastName(String lastName);
    Contact findContactByFirstNameAndLastName(String firstName, String lastName);
    Contact findContactByEmail(String email);

}
