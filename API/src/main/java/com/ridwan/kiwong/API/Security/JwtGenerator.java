/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Security;

import com.ridwan.kiwong.API.Dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 *
 * @author kiwong
 */

@Component
public class JwtGenerator {
    
    
  public String generate(UserDto jwtUser) {
        
         
   
        
        
        /*Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
        
        claims.put("userId", String.valueOf(jwtUser.getId()));
       // claims.put("role", jwtUser.get);
        
               return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,"youtube").compact();
          */
        
        Claims claims = Jwts.claims().setSubject(jwtUser.getuSerName());
        claims.put("id", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact();   
  }   
  
    }