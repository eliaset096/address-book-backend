package com.et.addressbook.services;


import com.et.addressbook.entities.Contact;

import java.util.List;

public interface IContactService {

    boolean isExistContact(long contId);
    Contact addContact(Contact contact);
    Contact modifyContact(Contact contact);
    Contact searchContact(long contId);
    Contact searchContactByFirstName(String firtsName);
    Contact searchContactByLastName(String lastName);
    Contact deleteContact(Contact contact);
    Iterable<Contact> getContacts();

}
