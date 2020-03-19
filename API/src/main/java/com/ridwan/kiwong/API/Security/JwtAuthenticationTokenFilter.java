/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Security;

import com.ridwan.kiwong.API.Model.JwtAuthenticationToken;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

/**
 *
 * @author kiwong
 */

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{
    
    
    public JwtAuthenticationTokenFilter(){
        super("/User/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest hsr, HttpServletResponse hsr1) throws AuthenticationException, IOException, ServletException {
    String header = hsr.getHeader("Authorization");
        System.out.println(header);
        
    if (header==null || !header.startsWith("Bearer")){ 
        System.out.println(header);
           throw new RuntimeException(header);
//throw new RuntimeException("Jwt Token Is Missing");
    }
    
    String authenticationtokenfilter = header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationtokenfilter);
        return getAuthenticationManager().authenticate(token);
    
            
        
     
        
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult); 
        chain.doFilter(request, response);

//To change body of generated methods, choose Tools | Templates.
    }
    
}
