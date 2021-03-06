/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.contacttype.ContactType;
import com.hackengine.dboperations.Operations;
import com.hackengine.entities.FriendContacts;
import com.hackengine.entities.HomeAddress;
import com.hackengine.entities.OfficeAddress;
import com.hackengine.entities.Users;
import com.hackengine.relationships.Relationships;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.io.Serializable;
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
public class UserBean implements Serializable {

    private static Users user = null;

    private List<HomeAddress> homeAdresses;

    private List<OfficeAddress> officeAddresses;

    private List<FriendContacts> friendContacts;

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

    private String name;

    private String surname;

    private String contact;

    private Relationships relationship;

    private ContactType contactType;

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

    public List<HomeAddress> getHomeAdresses() {
        return homeAdresses;
    }

    public void setHomeAdresses(List<HomeAddress> homeAdresses) {
        this.homeAdresses = homeAdresses;
    }

    public void setOfficeAddresses(List<OfficeAddress> officeAddresses) {
        this.officeAddresses = officeAddresses;
    }

    public List<OfficeAddress> getOfficeAddresses() {
        return officeAddresses;
    }

    public List<FriendContacts> getFriendContacts() {
        return friendContacts;
    }

    public void setFriendContacts(List<FriendContacts> friendContacts) {
        this.friendContacts = friendContacts;
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

    public Relationships getRelationship() {
        return relationship;
    }

    public ContactType getContactType() {
        return contactType;
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

    public void setRelationship(Relationships relationship) {
        this.relationship = relationship;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @PostConstruct
    public void init() {
        user = (Users) SessionUtils.getSession().getAttribute(Tags.LOGGED_USER);
        operations = new Operations();
        homeAdresses = Operations.getHomeAddresses(user.getID());
        officeAddresses = Operations.getOfficeAddresses(user.getID());
        friendContacts = Operations.getFriendContacts(user.getID());
    }

    public String logOut() {
        Operations.closeSession();
        SessionUtils.getSession().invalidate();
        return Tags.THANKS;
    }

    public void addHomeAddress() {
        operations.mapHomeAddressToUser(user, new HomeAddress(country, city, district, street, doorno));
        homeAdresses = Operations.getHomeAddresses(user.getID());
    }

    public void addOfficeAddress() {
        operations.mapOfficeAddressToUser(user, new OfficeAddress(ocountry, ocity, odistrict, ostreet, odoorno));
        officeAddresses = Operations.getOfficeAddresses(user.getID());
    }

    public void deleteHomeAddress(HomeAddress address) {
        operations.deleteHomeAddress(address);
        homeAdresses = Operations.getHomeAddresses(user.getID());
    }

    public void deleteOfficeAddress(OfficeAddress address) {
        operations.deleteOfficeAddress(address);
        officeAddresses = Operations.getOfficeAddresses(user.getID());
    }

    public ContactType[] getContactTypes() {
        return ContactType.values();
    }

    public Relationships[] getRelationships() {
        return Relationships.values();
    }

    public void addFriendContact() {
        operations.mapFriendContactToUser(user, new FriendContacts(name, surname, contactType, relationship, contact));
        friendContacts = Operations.getFriendContacts(user.getID());
    }

    public void deleteFriendContact(FriendContacts friendContact) {
        operations.deleteFriendContact(friendContact);
        friendContacts = Operations.getFriendContacts(user.getID());
    }
}