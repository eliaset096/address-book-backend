package com.et.addressbook.controllers;

import com.et.addressbook.entities.Contact;
import com.et.addressbook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/address-book")
public class ContactController implements IContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact contactToAdd = null;
        if (!contactService.isExistContact(contact.getContId())){
            contactToAdd = contactService.addContact(contact);
            return new ResponseEntity<Contact>(contactToAdd, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactToAdd, HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/update")
    public ResponseEntity<Contact> modifyContact(@RequestBody Contact contact) {
        Contact contactToModify = null;
        if (contactService.isExistContact(contact.getContId())){
            contactToModify = contactService.modifyContact(contact);
            return new ResponseEntity<Contact>(contactToModify, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactToModify, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/cont-id/{contId}")
    public ResponseEntity<Contact> getContact(@PathVariable("contId") long contId) {
        Contact contactSearched = null;
        if (contactService.isExistContact(contId)){
            contactSearched = contactService.searchContact(contId);
            return new ResponseEntity<Contact>(contactSearched, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactSearched, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/first-name/{firstName}")
    public ResponseEntity<Contact> getContactByFirstName(@PathVariable("firstName") String firstName) {
        Contact contactSearched = null;
        if (contactService.searchContactByFirstName(firstName)!=null){
            contactSearched = contactService.searchContactByFirstName(firstName);
            return new ResponseEntity<Contact>(contactSearched, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactSearched, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/last-name/{lastName}")
    public ResponseEntity<Contact> getContactByLastName(@PathVariable("lastName") String lastName) {
        Contact contactSearched = null;
        if (contactService.searchContactByLastName(lastName)!=null){
            contactSearched = contactService.searchContactByLastName(lastName);
            return new ResponseEntity<Contact>(contactSearched, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactSearched, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/first-name-and-last-name/{firstName} {lastName}")
    public ResponseEntity<Contact> getContactByFistNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        Contact contactSearched = null;
        if (contactService.searchContactByFirstName(firstName)!=null && contactService.searchContactByLastName(lastName)!=null){
            contactSearched = contactService.searchContactByFirstNameAndLastName(firstName, lastName);
            return new ResponseEntity<Contact>(contactSearched, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactSearched, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/email/{email}")
    public ResponseEntity<Contact> getContactByEmail(@PathVariable("email")  String email) {
        Contact contactSearched = null;
        if (contactService.searchContactByEmail(email)!=null){
            contactSearched = contactService.searchContactByEmail(email);
            return new ResponseEntity<Contact>(contactSearched, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactSearched, HttpStatus.BAD_REQUEST);
    }

    @Override
    @PostMapping("/delete")
    public ResponseEntity<Contact> deleteContact(@RequestBody Contact contact) {
        Contact contactToDelete = null;
        if (contactService.isExistContact(contact.getContId())){
            contactToDelete= contactService.deleteContact(contact);
            return new ResponseEntity<Contact>(contactToDelete, HttpStatus.OK);
        }
        return new ResponseEntity<Contact>(contactToDelete, HttpStatus.BAD_REQUEST);
    }

    @Override
    @GetMapping("/contacts")
    public ResponseEntity<Iterable<Contact>> getContacts() {
        return new ResponseEntity<Iterable<Contact>>(contactService.getContacts(), HttpStatus.OK);
    }
}
