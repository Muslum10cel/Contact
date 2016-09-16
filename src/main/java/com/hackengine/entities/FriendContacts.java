/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.contacttype.ContactType;
import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import com.hackengine.relationships.Relationships;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.CONTACT_OF_FRIENDS)
public class FriendContacts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.NAME, nullable = false, updatable = true)
    private String name;

    @Column(name = ColumnNames.SURNAME, nullable = false, updatable = true)
    private String surname;

    @Column(name = ColumnNames.CONTACT, nullable = false, updatable = true)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnNames.CONTACT_TYPE, nullable = false, updatable = true)
    private ContactType contactType;

    @Enumerated(EnumType.STRING)
    @Column(name = ColumnNames.RELATION, nullable = false, updatable = true)
    private Relationships relationship;

    @ManyToOne
    @JoinColumn(name = ColumnNames.USER_ID)
    private Users users;

    public FriendContacts() {
    }

    public FriendContacts(String name, String surname, ContactType contactType, Relationships relationship, String contact) {
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        this.contactType = contactType;
        this.relationship = relationship;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getContact() {
        return contact;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public Relationships getRelationship() {
        return relationship;
    }

    public Users getUsers() {
        return users;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setRelationship(Relationships relationship) {
        this.relationship = relationship;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "FriendContacts{" + "name=" + name + ", surname=" + surname + ", contact=" + contact + ", contactType=" + contactType + ", relationship=" + relationship + '}';
    }
}
