/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.dboperations.Operations;
import com.hackengine.entities.HomeAddress;
import com.hackengine.entities.OfficeAddress;
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

    private String ocountry;

    private String ocity;

    private String odistrict;

    private String ostreet;

    private String odoorno;

    public String getOcountry() {
        return ocountry;
    }

    public String getOcity() {
        return ocity;
    }

    public String getOdistrict() {
        return odistrict;
    }

    public String getOstreet() {
        return ostreet;
    }

    public String getOdoorno() {
        return odoorno;
    }

    public void setOcountry(String ocountry) {
        this.ocountry = ocountry;
    }

    public void setOcity(String ocity) {
        this.ocity = ocity;
    }

    public void setOdistrict(String odistrict) {
        this.odistrict = odistrict;
    }

    public void setOstreet(String ostreet) {
        this.ostreet = ostreet;
    }

    public void setOdoorno(String odoorno) {
        this.odoorno = odoorno;
    }

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

    @PostConstruct
    public void init() {
        user = (Users) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        operations = new Operations();
    }

    public String logOut() {
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }

    public void addHomeAddress() {
        HomeAddress address = new HomeAddress(country, city, district, street, doorno);
        operations.mapHomeAddressToUser(user, address);
    }

    public void addOfficeAddress() {
        OfficeAddress officeAddress = new OfficeAddress(ocountry, ocity, odistrict, ostreet, odoorno);
        operations.mapOfficeAddressToUser(user, officeAddress);
    }
}
