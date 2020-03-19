/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Security;

import com.ridwan.kiwong.API.Error.errorException;
import com.ridwan.kiwong.API.Model.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 *
 * @author kiwong
 */
@Component
public class JwtValidator {
    private String secret ="youtube";
    
 public UserModel validate(String token){
     UserModel userModel = null;
     try {
         Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
         
         userModel = new UserModel();
         userModel.setUserName((String) body.get("username"));
         userModel.setId((int) body.get("id"));
         userModel.setRole((String) body.get("role"));
         
     }catch (Exception e){
         System.out.print(e);
     }
     return userModel;
 }   
}
