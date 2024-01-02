package com.areeba.areeba_phone_validation.exception;

/***
 * Exception for business logic from phone verification service.
 * @author Johnny Abi Mansour
 *
 */
public class InvalidMobileNumberException extends Exception {

    public InvalidMobileNumberException(String message){
        super(message);
    }
}
