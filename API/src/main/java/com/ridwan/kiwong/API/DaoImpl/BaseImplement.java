/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author kiwong
 */
public class BaseImplement {
    @PersistenceContext
    protected EntityManager em;
    @PersistenceUnit
    protected EntityManagerFactory emf;
}
