/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.config;

import com.ridwan.kiwong.API.Dao.UserDao;
import com.ridwan.kiwong.API.DaoImpl.UserDaoImplement;
import com.ridwan.kiwong.API.Model.JwtAuthenticationToken;
import com.ridwan.kiwong.API.Security.JwtAuthenticationEntryPoint;
import com.ridwan.kiwong.API.Security.JwtAuthenticationProvider;
import com.ridwan.kiwong.API.Security.JwtAuthenticationTokenFilter;
import com.ridwan.kiwong.API.Security.JwtSecurityHandler;
import java.util.Collection;
import java.util.Collections;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author kiwong
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class DaoSpringConfig extends WebSecurityConfigurerAdapter{
     
    
    
    
   @Autowired
   private JwtAuthenticationProvider authenticationProvider;
    @Autowired  
    public JwtAuthenticationEntryPoint EntryPoint;
    
    
    
     @Bean
    public UserDao orangDao(){
        return new UserDaoImplement();
    }
    
    
    @Bean
    public WebMvcConfigurerAdapter corsConfigurer(){
        return new WebMvcConfigurerAdapter() {

        @Override
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE").allowedOrigins("*").allowedHeaders("*");
        }
        
        };
    }
    
     @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
    
  
    @Bean
    public AuthenticationManager authenticationManager(){
      
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }
    
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter(){
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSecurityHandler());
        return filter;
    }
    
      @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().antMatchers("**/rest/**").authenticated().and().exceptionHandling()
                .authenticationEntryPoint(EntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
            
          
            
}
