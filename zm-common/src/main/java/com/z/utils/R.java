package com.z.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class R {

    public static <T> ResponseEntity<T> create(T t){
        return new ResponseEntity<T>(t, HttpStatus.OK);
    }
    public static <T> ResponseEntity<T> create(T t,HttpStatus status){
        return new ResponseEntity<T>(t, status);
    }

}
