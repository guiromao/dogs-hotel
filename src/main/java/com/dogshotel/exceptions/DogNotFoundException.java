package com.dogshotel.exceptions;

public class DogNotFoundException extends RuntimeException{

    public DogNotFoundException(String s){
        super(s);
    }

}
