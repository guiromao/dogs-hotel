package com.dogshotel.controllers;

import com.dogshotel.models.Dog;
import com.dogshotel.models.Owner;
import com.dogshotel.services.DogService;
import com.dogshotel.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class HotelController {

    @GetMapping("/")
    public ResponseEntity<Map> welcome(){
        Map<String, String> respMap = new HashMap<>();
        respMap.put("message", "Welcome to the Dogs Hotel API!");

        return new ResponseEntity<>(respMap, HttpStatus.ACCEPTED);
    }

    @GetMapping({"/date", "date"})
    public ResponseEntity<Map> getDate(){
        Map<String, String> respMap = new HashMap<>();
        respMap.put("date", String.valueOf(new Date()));

        return new ResponseEntity<>(respMap, HttpStatus.ACCEPTED);
    }

}
