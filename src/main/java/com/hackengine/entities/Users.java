/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author muslumoncel
 */
@Entity
@Table(name = "USERS")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = "USERNAME", length = 20, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "PASSWORD", length = 128, nullable = false, updatable = true)
    private String password;

    @Column(name = "E_MAIL", length = 50, nullable = false, updatable = true, unique = true)
    private String email;

    @Column(name = "JOINED_DATE", length = 11)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar joinedDate;


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

    @Override
    public String toString() {
        return "User Registered --> "
                + "[ USERNAME = " + username
                + ", PASSWORD=" + password
                + "]";
    }
}
