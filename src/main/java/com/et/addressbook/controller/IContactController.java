package com.et.addressbook.controller;

import com.et.addressbook.entities.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IContactController {


    @PostMapping("/add")
    ResponseEntity<Contact> addContact(@RequestBody Contact contact);

    @PutMapping("/update")
    ResponseEntity<Contact> modifyContact(@RequestBody Contact contact);

    @GetMapping("/cont_id/{contId}")
    ResponseEntity<Contact> getContact(@PathVariable("contId") long contId);

    @GetMapping("/first_name/{firstName}")
    ResponseEntity<Contact> getContactByFirstName(@PathVariable("firstName") String firtsName);

    @GetMapping("/last_name/{lastName}")
    ResponseEntity<Contact> getContactByLastName(@PathVariable("lastName") String lastName);

    @DeleteMapping("/delete")
    ResponseEntity<Contact> deleteContact(@RequestBody Contact contact);

    @GetMapping("/contacts")
    ResponseEntity<Iterable<Contact>> getContacts();



}
