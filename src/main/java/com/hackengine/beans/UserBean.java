/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.dboperations.Operations;
import com.hackengine.entities.HomeAddress;
import com.hackengine.entities.Users;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static Users user = null;

    private Operations operations = null;

    private String country;

    private String city;

    private String district;

    private String street;

    private String doorno;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
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

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getDoorno() {
        return doorno;
    }

    public void printUser() {
        System.out.println(user);
    }

    @PostConstruct
    public void init() {
        user = (Users) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        operations = new Operations();
    }

    public String logOut() {
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }

    public void addAddress() {
        HomeAddress address = new HomeAddress(country, city, district, street, doorno);
        operations.mapHomeAddressToUser(user, address);
    }
}
