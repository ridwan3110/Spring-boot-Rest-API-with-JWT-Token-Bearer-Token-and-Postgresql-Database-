/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.DaoImpl;

import com.ridwan.kiwong.API.Dao.UserDao;
import com.ridwan.kiwong.API.Error.errorException;
import com.ridwan.kiwong.API.Model.UserModel;
import com.ridwan.kiwong.API.Repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kiwong
 */
public class UserDaoImplement extends BaseImplement implements UserDao{

    @Autowired
   private UserRepository userRepository; 
    
    @Override
    public UserModel getById(int id) throws Exception {
    return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel save(UserModel userModel) throws errorException {
    return userRepository.save(userModel);
    }

    @Override
    public void delete(UserModel userModel) throws errorException {
    userRepository.delete(userModel);
    }

    @Override
    public List<UserModel> getList() throws errorException {
       CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserModel> query = cb.createQuery(UserModel.class);
        Root<UserModel> root = query.from(UserModel.class);
        query.select(root);
        
        TypedQuery <UserModel> query1 =  em.createQuery(query);
        return query1.getResultList();
       
       
        
    }
    
}
