/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.contacttype.ContactType;
import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = TableNames.CONTACT_OF_USER)
public class ContactOfUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Enumerated
    @Column(name = ColumnNames.CONTACT_TYPE, updatable = true)
    private ContactType contactType;

    @Column(name = ColumnNames.PHONE, updatable = true)
    private String phone;

    @Column(name = ColumnNames.E_MAIL, updatable = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = ColumnNames.USER_ID)
    private Users users;
    
    public ContactOfUser() {
    }

    public ContactOfUser(ContactType contactType, String phone, String email) {
        this.contactType = contactType;
        this.phone = phone;
        this.email = email;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public int getID() {
        return ID;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactOfUser{" + "ID=" + ID + ", contactType=" + contactType + ", phone=" + phone + ", email=" + email + '}';
    }

}
