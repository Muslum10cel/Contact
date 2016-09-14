/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackengine.passtohash;

import com.hackengine.tags.Tags;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author muslumoncel
 */
public class PassToHash {

    public static final String passToHash(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance(Tags.ALGORITHM_FOR_HASH);
            md.update(pass.getBytes(Tags.CHARSET_NAME));
            byte[] digest = md.digest();
            return String.format(Tags.FORMAT, new java.math.BigInteger(1, digest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
        }
        return null;
    }
}
