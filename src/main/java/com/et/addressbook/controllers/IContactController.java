package com.et.addressbook.controllers;

import com.et.addressbook.entities.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IContactController {

    ResponseEntity<Contact> addContact(@RequestBody Contact contact);

    ResponseEntity<Contact> modifyContact(@PathVariable("contId") long contId, @RequestBody Contact contact);

    ResponseEntity<Contact> getContact(@PathVariable("contId") long contId);

    ResponseEntity<Contact> getContactByFirstName(@PathVariable("firstName") String firtsName);

    ResponseEntity<Contact> getContactByLastName(@PathVariable("lastName") String lastName);

    ResponseEntity<Contact> getContactByFistNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName);

    ResponseEntity<Contact> getContactByEmail(@PathVariable String email);

    ResponseEntity<Contact> deleteContact(@PathVariable("contId") long contId);

    ResponseEntity<Iterable<Contact>> getContacts();



}
