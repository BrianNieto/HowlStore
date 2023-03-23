package com.asj.bootcamp.service;

import com.asj.bootcamp.entity.Contact;

public interface ContactService {

    void createContacto(Contact contact);

    Contact getContacto(Integer id);

    Contact updateContacto(Integer id, Contact tmp);

    void deleteContacto(Integer id);
}