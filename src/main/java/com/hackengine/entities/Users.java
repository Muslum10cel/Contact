/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import com.hackengine.tags.Tags;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = TableNames.USER)
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.USERNAME, length = 20, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = ColumnNames.PASSWORD, length = 128, nullable = false, updatable = true)
    private String password;

    @Column(name = ColumnNames.E_MAIL, length = 50, nullable = false, updatable = true, unique = true)
    private String email;

    @Column(name = ColumnNames.JOINED_DATE, length = 11)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar joinedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_USER)
    private List<HomeAddress> homeAddresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_USER)
    private List<OfficeAddress> officeAddress;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = Tags.MAPPED_BY_USER)
    private List<ContactOfUser> contactOfUser;
    
    public Users() {
    }

    public Users(String username, String password, String email, Calendar joinedDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.joinedDate = joinedDate;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setContactOfUser(List<ContactOfUser> contactOfUser) {
        this.contactOfUser = contactOfUser;
    }

    public List<ContactOfUser> getContactOfUser() {
        return contactOfUser;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return ID;
    }

    public Calendar getJoinedDate() {
        return joinedDate;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setJoinedDate(Calendar joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<HomeAddress> getHomeAddresses() {
        return homeAddresses;
    }

    public void setHomeAddresses(List<HomeAddress> homeAddresses) {
        this.homeAddresses = homeAddresses;
    }

    public List<OfficeAddress> getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(List<OfficeAddress> officeAddress) {
        this.officeAddress = officeAddress;
    }
    
    @Override
    public String toString() {
        return "Users{" + "ID=" + ID + ", username=" + username + ", password=" + password + ", email=" + email + ", joinedDate=" + joinedDate + ", homeAddresses=" + homeAddresses + '}';
    }
}
