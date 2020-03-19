/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Controller;

import com.ridwan.kiwong.API.DaoImpl.BaseImplement;
import com.ridwan.kiwong.API.Dto.UserDto;
import com.ridwan.kiwong.API.Model.UserModel;
import com.ridwan.kiwong.API.Security.JwtGenerator;
import javax.persistence.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kiwong
 */
@RestController
@RequestMapping("/token")
public class TokenController extends BaseImplement{
    
    private JwtGenerator jwtGenerator;
    
    
    
    @PostMapping
    public String generate(@RequestBody final UserDto jwtUser){
        
        
        
        Query query = em.createNativeQuery("select * from kiwong.orang where username=:username and id=:id", UserModel.class);
         query.setParameter("username", jwtUser.getUsername());
         query.setParameter("id", jwtUser.getId());
         if (query.getResultList().isEmpty()){
             System.out.println(query.getResultList());
               System.out.println(query);
         return "Username dan ID tidak sesuai";
        //return jwtGenerator.generate(jwtUser);    
         }else {
             System.out.println(query.getResultList());
         //return "Username dan ID tidak sesuai";
           return jwtGenerator.generate(jwtUser);    
         }
    }
    
    
     public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }
    
}