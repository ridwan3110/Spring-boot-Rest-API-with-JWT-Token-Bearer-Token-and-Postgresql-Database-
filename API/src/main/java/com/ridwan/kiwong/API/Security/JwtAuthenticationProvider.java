/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Security;

import com.ridwan.kiwong.API.Dto.UserDto;
import com.ridwan.kiwong.API.Model.JwtAuthenticationToken;
import com.ridwan.kiwong.API.Model.UserModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author kiwong
 */

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
    
       /* @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
    return null;   
    }*/
    
    
    @Autowired
    private JwtValidator validator;

    @Override
    public boolean supports(Class<?> aClass) {
     return (JwtAuthenticationToken.class.isAssignableFrom(aClass)); 
    }

    
    
    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        
    }

    @Override
    protected UserDetails retrieveUser(String Username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;  
    
    String token = jwtAuthenticationToken.getToken();
        UserModel jwtUser = validator.validate(token);
        
        if (jwtUser==null){
            throw new RuntimeException("JWT Token is Incorrect");
        }
        
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
        
        return new UserDto(jwtUser.getId(), jwtUser.getNamaLengkap(), jwtUser.getUserName(), jwtUser.getPassword(), jwtUser.getAlamat(), 
                String.valueOf(jwtUser.getTelp()), jwtUser.getTanggalMasuk(), jwtUser.getTanggalKeluar(), jwtUser.getRole(), token, grantedAuthorities);
        
        
    }
    
}
