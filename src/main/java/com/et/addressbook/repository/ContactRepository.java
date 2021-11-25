package com.et.addressbook.repository;

import com.et.addressbook.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("select c from Contact c where c.firstName = ?1")
    Contact findContactByFirstName(String firstName);

    @Query("select c from Contact c where c.lastName = ?1")
    Contact findContactByLastName(String lastName);


}
