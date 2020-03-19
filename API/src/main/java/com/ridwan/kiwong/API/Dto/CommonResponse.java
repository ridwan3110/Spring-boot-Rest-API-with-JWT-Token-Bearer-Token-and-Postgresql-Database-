/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.kiwong.API.Dto;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author kiwong
 */
public class CommonResponse<T> {
    private String message;
    private String status;
    private T values;

    public CommonResponse() {
        this.status ="00";
        this.message="Succes";
    }

    
    public CommonResponse(T data) {
        this();
        this.values = data;
    }
    
    public CommonResponse(String message, String status, T data) {
        this.message = message;
        this.status = status;
        this.values = data;
    }
    
    public CommonResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getValues() {
        return values;
    }

    public void setValues(T values) {
        this.values = values;
    }
    
    
    
    
    
    
    
    
    
}
