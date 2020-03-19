/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Repository;

import com.ridwan.kiwong.API.Model.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.io.Serializable;

/**
 *
 * @author kiwong
 */
public interface UserRepository extends PagingAndSortingRepository<UserModel, Integer>{
    
}
