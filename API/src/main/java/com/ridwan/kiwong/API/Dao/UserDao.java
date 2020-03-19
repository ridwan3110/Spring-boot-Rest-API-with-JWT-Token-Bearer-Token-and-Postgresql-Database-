/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Dao;

import com.ridwan.kiwong.API.Model.UserModel;
import java.util.List;

/**
 *
 * @author kiwong
 */
public interface UserDao {
    UserModel getById(int id) throws Exception;
    UserModel save(UserModel userModel) throws Exception;
    void delete(UserModel userModel) throws Exception;
    List<UserModel> getList() throws Exception;
}
