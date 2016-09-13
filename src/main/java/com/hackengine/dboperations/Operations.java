/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.dboperations;

import com.hackengine.entities.ContactOfUser;
import com.hackengine.entities.HomeAddress;
import com.hackengine.entities.OfficeAddress;
import com.hackengine.entities.Users;
import com.hackengine.queries.Queries;
import com.hackengine.tags.Tags;
import com.hackengine.utils.SessionUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author muslumoncel
 */
public class Operations {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static Session session = null;

    private static void openSession() {
        session = factory.openSession();
    }

    public String register(Users register) {
        try {
            openSession();
            saveUserInfo(register);
            System.out.println(register);
            return Tags.SUCCESS;
        } catch (Exception e) {
            return Tags.FAIL;
        }

    }

    public String login(Users login) {
        openSession();
        List<Users> result = session.createQuery(Queries.LOG_IN_QUERY).setString(0, login.getUsername()).list();
        if (result != null) {
            if (result.get(0).getPassword().equals(login.getPassword())) {
                SessionUtils.getSession().setAttribute(Tags.LOGGED_USER, result.get(0));
                return Tags.SUCCESS;
            }
        }
        return Tags.FAIL;
    }

    private void saveUserInfo(Users u) {
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
    }

    public void mapHomeAddressToUser(Users user, HomeAddress address) {
        openSession();
        session.beginTransaction();
        session.save(address);
        address.setUsers(user);
        user.getHomeAddresses().add(address);
        session.getTransaction().commit();
    }

    public void mapOfficeAddressToUser(Users user, OfficeAddress officeAddress) {
        openSession();
        session.beginTransaction();
        session.save(officeAddress);
        officeAddress.setUsers(user);
        user.getOfficeAddress().add(officeAddress);
        session.getTransaction().commit();
    }

    public void mapContactToUser(Users user, ContactOfUser contactOfUser) {
        openSession();
        session.beginTransaction();
        session.save(contactOfUser);
        contactOfUser.setUsers(user);
        user.getContactOfUser().add(contactOfUser);
        session.getTransaction().commit();
    }

    public static List<HomeAddress> getHomeAddresses(int id) {
        return session.createQuery(Queries.GET_HOME_ADDRESSES).setInteger(0, id).list();
    }

    public static List<OfficeAddress> getOfficeAddresses(int id) {
        return session.createQuery(Queries.GET_OFFICE_ADDRESSES).setInteger(0, id).list();
    }
}
