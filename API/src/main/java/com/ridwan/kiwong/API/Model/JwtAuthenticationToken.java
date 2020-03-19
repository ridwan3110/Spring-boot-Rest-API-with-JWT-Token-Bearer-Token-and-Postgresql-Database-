/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author kiwong
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{
    
    private String token;
    
    public JwtAuthenticationToken(String Token) {
        super(null, null);
        this.token=Token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    @Override
    public Object getPrincipal() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getCredentials() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    
}
