/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.queries;

/**
 *
 * @author muslumoncel
 */
public class Queries {

    public static final String LOG_IN_QUERY = "FROM Users U WHERE U.username = ?";
    public static final String GET_HOME_ADDRESSES = "FROM HomeAddress HA WHERE HA.users.ID=?";
    public static final String GET_OFFICE_ADDRESSES = "FROM OfficeAddress OA WHERE OA.users.ID=?";
    public static final String GET_USER_CONTACTS = "FROM ContactOfUser CU WHERE CU.users.ID=?";
    public static final String GET_FRIEND_CONTACTS = "FROM FriendContacts FC WHERE FC.users.ID=?";
}
