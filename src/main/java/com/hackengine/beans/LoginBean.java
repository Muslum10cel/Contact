/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.beans;

import com.hackengine.dboperations.Operations;
import com.hackengine.entities.Users;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author muslumoncel
 */
@ManagedBean
public class LoginBean implements Serializable{

    private String username;
    private String password;

    public LoginBean() {
    }

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        return (new Operations()).login(new Users(username, password));
    }
}
