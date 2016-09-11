/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.entities;

import com.hackengine.db.ColumnNames;
import com.hackengine.db.TableNames;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = TableNames.HOME_ADDRESS)
public class HomeAddress implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = ColumnNames.COUNTRY, nullable = false, updatable = true)
    private String country;

    @Column(name = ColumnNames.CITY, nullable = false, updatable = true)
    private String city;

    @Column(name = ColumnNames.DISTRICT, nullable = false, updatable = true)
    private String district;

    @Column(name = ColumnNames.STREET, nullable = false, updatable = true)
    private String street;

    @Column(name = ColumnNames.DOOR_NO, nullable = false, updatable = true)
    private String doorno;

    public HomeAddress() {
    }

    @ManyToOne
    @JoinColumn(name = ColumnNames.USER_ID)
    private Users users;

    public HomeAddress(String country, String city, String district, String street, String doorno) {
        this.country = country;
        this.city = city;
        this.district = district;
        this.street = street;
        this.doorno = doorno;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDoorno(String doorno) {
        this.doorno = doorno;
    }

    public int getID() {
        return ID;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getDoorno() {
        return doorno;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "HomeAddress{" + "ID=" + ID + ", country=" + country + ", city=" + city + ", district=" + district + ", street=" + street + ", doorno=" + doorno + '}';
    }
}
