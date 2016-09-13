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

    public static final String LOG_IN_QUERY = "SELECT U FROM Users U WHERE U.username = ?";
    public static final String GET_HOME_ADDRESSES = "FROM HomeAddress HA WHERE HA.users.ID=?";
    public static final String GET_OFFICE_ADDRESSES = "FROM OfficeAddress OA WHERE OA.users.ID=?";
}
