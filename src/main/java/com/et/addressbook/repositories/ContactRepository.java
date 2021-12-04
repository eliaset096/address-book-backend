package com.et.addressbook.repositories;

import com.et.addressbook.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("select c from Contact c where c.firstName = ?1")
    Contact findContactByFirstName(String firstName);

    @Query("select c from Contact c where c.lastName = ?1")
    Contact findContactByLastName(String lastName);

    @Query("select c from Contact c where c.firstName = ?1 and c.lastName = ?2")
    Contact findContactByFirstNameAndLastName(String firstName, String lastName);

    @Query("select c from Contact c where c.email = ?1")
    Contact findContactByEmail(String email);

}
