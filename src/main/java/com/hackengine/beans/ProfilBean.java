/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.contacttype.ContactType;
import com.hackengine.dboperations.Operations;
import com.hackengine.entities.ContactOfUser;
import com.hackengine.entities.Users;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class ProfilBean {

    private static Users user = null;

    private Operations operations;

    private List<ContactOfUser> contacts;

    private String pcontact;

    private ContactType pcontactType;

    @PostConstruct
    public void init() {
        user = (Users) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        operations = new Operations();
        contacts = Operations.getUserContacts(user.getID());
    }

    public ContactType[] getTypes() {
        return ContactType.values();
    }

    public void setContacts(List<ContactOfUser> contacts) {
        this.contacts = contacts;
    }

    public List<ContactOfUser> getContacts() {
        return contacts;
    }

    public String getContact() {
        return pcontact;
    }

    public ContactType getContactType() {
        return pcontactType;
    }

    public void setContact(String contact) {
        this.pcontact = contact;
    }

    public void setContactType(ContactType contactType) {
        this.pcontactType = contactType;
    }

    public void addContact() {
        operations.mapContactToUser(user, new ContactOfUser(pcontactType, pcontact));
        contacts = Operations.getUserContacts(user.getID());
    }

    public void deleteContact(ContactOfUser contactOfUser) {
        operations.deleteContact(contactOfUser);
        contacts = Operations.getUserContacts(user.getID());
    }
}
