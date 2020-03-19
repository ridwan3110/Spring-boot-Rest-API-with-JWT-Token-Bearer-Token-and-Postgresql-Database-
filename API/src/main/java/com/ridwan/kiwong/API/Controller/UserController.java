/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Controller;

import com.ridwan.kiwong.API.Dao.UserDao;
import com.ridwan.kiwong.API.Dto.CommonResponse;
import com.ridwan.kiwong.API.Dto.UserDto;
import com.ridwan.kiwong.API.Error.errorException;
import com.ridwan.kiwong.API.Model.UserModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kiwong
 */
@RestController
@RequestMapping("/User")
@SuppressWarnings("rawtypes")
public class UserController {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserModel.class);
            
            
    @Autowired
    private UserDao userDao;
    
    
	@Autowired
	private ModelMapper modelmapper; 
    
    @GetMapping(value="/getbyid/{id}")
    public CommonResponse getById(@PathVariable("id") String id) throws errorException{
        LOGGER.info("id : {} ", id);
        try {
             UserModel userModel = userDao.getById(Integer.parseInt(id));
        if (userModel==null){
            return new CommonResponse("15", "Customer Tidak Ditemukan");
        }
        return new CommonResponse<UserDto>(modelmapper.map(userModel, UserDto.class));
        }catch (errorException e) {
            LOGGER.error(e.getMessage());
            return new CommonResponse("01", e.getMessage());
        }catch (NumberFormatException e1){
            LOGGER.error(e1.getMessage());
            return new CommonResponse("06", "Parameter Harus Angka");
        }catch (Exception e2){
            LOGGER.error(e2.getMessage());
            return new CommonResponse("06", e2.getMessage());
        }
       
    }
    
    
    @PostMapping(value="")
    public CommonResponse insert (@RequestBody UserDto userDto) throws errorException{
            try {
                UserModel userModel = modelmapper.map(userDto, UserModel.class);
                userModel.setId(0);
                userModel = userDao.save(userModel);
                
                return new CommonResponse<UserDto>(modelmapper.map(userModel, UserDto.class));
            }catch (errorException e){
                return new CommonResponse("01", e.getMessage());
            }catch (Exception e1){
                 LOGGER.error(e1.getMessage());
                return new CommonResponse("06", e1.getMessage());
            }
    }
    
    
    @DeleteMapping(value="{orang}")
    public CommonResponse delete (@PathVariable("orang") Integer id) throws errorException{
        
        try {
            UserModel userModel = userDao.getById(id);
            if (userModel==null){
                return new CommonResponse("05", "Customer Tidak Ditemukan");
            }
            userDao.delete(userModel);
            return new CommonResponse();
        } catch (errorException ex) {
            LOGGER.error(ex.getMessage());
            return new CommonResponse("01", ex.getMessage());
        }catch (Exception e){
            return new CommonResponse("02", e.getMessage());
        }
        
    }
    
    
    @PutMapping(value="")
    public CommonResponse update (@RequestBody UserDto userDto) throws errorException, Exception{
        try {
            UserModel userModel = userDao.getById(userDto.getId());
            if (userModel==null){
                return new CommonResponse("12", "Customer Tidak Ditemukan");
            }
            
            if (userDto.getuSerName()!=null){
                userModel.setUserName(userDto.getuSerName());
            }
            if (userDto.getPassword()!=null){
                userModel.setPassword(userDto.getPassword());
            }
            
            if (userDto.getNamaLengkap()!=null){
                userModel.setNamaLengkap(userDto.getNamaLengkap());
            }
            
            if (userDto.getAlamat()!=null){
                userModel.setAlamat(userDto.getAlamat());
            }
            if (userDto.getTanggalMasuk()!=null){
                userModel.setTanggalMasuk(userDto.getTanggalMasuk());
            }
            
            if (userDto.getTanggalKeluar()!=null){
                userModel.setTanggalKeluar(userDto.getTanggalKeluar());
            }
            
            if (userDto.getTelp()!=null){
                userModel.setTelp(Integer.valueOf(userDto.getTelp()));
            }
            
            if (userDto.getRole()!=null){
                userModel.setRole(userDto.getRole());
            }
            userModel = userDao.save(userModel);
            return new CommonResponse<UserDto>(modelmapper.map(userModel, UserDto.class));
            
        } catch (errorException ex) {
            LOGGER.error(ex.getMessage());
            return new CommonResponse("01", ex.getMessage());
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            return new CommonResponse("01", e.getMessage());
        }
    }
    
    
    @GetMapping(value="/getlist")
    public CommonResponse getlist(@RequestParam(name="orang", defaultValue = "")String orang) throws errorException, Exception{
       
        try {
             LOGGER.info("orang get list, param {}", orang);
            List<UserModel> userModels = userDao.getList();
            
            return new CommonResponse<List<UserDto>>(userModels.stream().map(usr->modelmapper.map(usr, UserDto.class)).collect(Collectors.toList()));
        }catch(NumberFormatException e) {
			return new CommonResponse("01", e.getMessage());
    }   
        catch (errorException ex) {
           LOGGER.error(ex.getMessage());
            return new CommonResponse("01", ex.getMessage());
        }catch (Exception ez) {
         throw ez;
    }
    
}
    
}