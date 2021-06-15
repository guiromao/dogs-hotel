package com.dogshotel.controllers;

import com.dogshotel.models.Dog;
import com.dogshotel.models.Owner;
import com.dogshotel.services.DogService;
import com.dogshotel.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class HotelController {

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        String welcomeStr = "Welcome to the Dogs Hotel API!";

        return new ResponseEntity<>(welcomeStr, HttpStatus.ACCEPTED);
    }

}
