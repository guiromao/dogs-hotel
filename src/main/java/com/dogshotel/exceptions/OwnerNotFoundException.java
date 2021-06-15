package com.dogshotel.exceptions;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(String msg){
        super(msg);
    }

}
