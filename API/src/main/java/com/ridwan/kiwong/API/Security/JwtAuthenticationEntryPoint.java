/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author kiwong
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest hsr, HttpServletResponse hsr1, AuthenticationException ae) throws IOException, ServletException {
     hsr1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");   
    }
    
}
