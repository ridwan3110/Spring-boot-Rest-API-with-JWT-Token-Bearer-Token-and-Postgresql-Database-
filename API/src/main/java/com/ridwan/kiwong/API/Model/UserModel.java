/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kiwong
 */
@Entity
@Table(name = "orang", schema = "kiwong")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
 
    
    @Column(name = "namalengkap")
    private String namaLengkap;
    
    @Column (name = "username")
    private String userName;
    
    @Column(name="password")
    private String Password;
    
    @Column(name="alamat")
    private String Alamat;
    
    @Column(name="telepon")
    private int Telp;
    
    @Column(name="tgl_masuk")
     @JsonFormat(pattern="yyyy-MM-dd")
    private Date tanggalMasuk;
    
    @Column(name="tanggal_keluar")
    private Date tanggalKeluar;
    
    @Column(name="role")
    private String Role;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getTelp() {
        return Telp;
    }

    public void setTelp(int Telp) {
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

   

    
    
    
}
