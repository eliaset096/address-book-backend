package com.et.addressbook.services;

import com.et.addressbook.entities.Contact;
import com.et.addressbook.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IContactService {

    ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public boolean isExistContact(String contId) {
        return contactRepository.findById(contId).isPresent();
    }

    @Override
    public Contact addContact(Contact contact){
        if (contactRepository.existsById(contact.getContId())){
            return null;
        }else {
            return contactRepository.save(contact);
        }
    }

    @Override
    public Contact modifyContact(Contact contact) {
        if (contactRepository.existsById(contact.getContId())){
            return contactRepository.save(contact);
        }else {
            return null;
        }
    }


    @Override
    public Contact searchContact(String contId) {
        return contactRepository.findById(contId).get();
    }

    @Override
    public Contact searchContactByFirstName(String firtsName) {
        return contactRepository.findContactByFirstName(firtsName);
    }

    @Override
    public Contact searchContactByLastName(String lastName) {
        return contactRepository.findContactByLastName(lastName);
    }

    @Override
    public Contact searchContactByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findContactByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Contact searchContactByEmail(String email) {
        return contactRepository.findContactByEmail(email);
    }

    @Override
    public Contact deleteContact(Contact contact) {
        Contact contactToDelete = null;
        if (contactRepository.existsById(contact.getContId())){
            contactRepository.delete(contact);
            contactToDelete = contact;
        }
        return contactToDelete;
    }

    @Override
    public Iterable<Contact> getContacts() {
        return contactRepository.findAll();
    }



}
