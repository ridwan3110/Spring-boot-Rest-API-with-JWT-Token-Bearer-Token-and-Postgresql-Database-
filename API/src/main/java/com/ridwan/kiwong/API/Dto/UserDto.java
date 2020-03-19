/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Dto;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author kiwong
 */
public class UserDto implements UserDetails{
    
    private int id;
    private String namaLengkap;
    private String uSerName;
    private String Password;
    private String Alamat;
    private String Telp;
    private Date tanggalMasuk;
    private Date tanggalKeluar;
    private String Role;
    private String token;
     //private Collection<? extends GrantedAuthority>authorities;
    private Collection<? extends GrantedAuthority>authoritys;
    

    public UserDto() {
    }

    public UserDto(int id, String namaLengkap, String uSerName, String Password, String Alamat, String Telp, Date tanggalMasuk, Date tanggalKeluar, String Role, String token, Collection<? extends GrantedAuthority> authoritys) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.uSerName = uSerName;
        this.Password = Password;
        this.Alamat = Alamat;
        this.Telp = Telp;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalKeluar = tanggalKeluar;
        this.Role = Role;
        this.token = token;
        this.authoritys = authoritys;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getuSerName() {
        return uSerName;
    }

    public void setuSerName(String uSerName) {
        this.uSerName = uSerName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getTelp() {
        return Telp;
    }

    public void setTelp(String Telp) {
        this.Telp = Telp;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(Collection<? extends GrantedAuthority> authoritys) {
        this.authoritys = authoritys;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return authoritys;
    }

    @Override
    public String getUsername() {
    return uSerName;
    }

    @Override
    public boolean isAccountNonExpired() {
    return true;    
    }

    @Override
    public boolean isAccountNonLocked() {
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;
    }

    @Override
    public boolean isEnabled() {
    return true;
    }

   
    
}
