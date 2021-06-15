package com.dogshotel.controllers;

import com.dogshotel.models.Dog;
import com.dogshotel.services.DogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogsController {

    @Autowired
    private DogService dogService;

    @GetMapping({"/", ""})
    public ResponseEntity<List<Dog>> listDogs(){
        return new ResponseEntity<>(dogService.listDogs(), HttpStatus.ACCEPTED);
    }

    @GetMapping("{dogId}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long dogId){
        return new ResponseEntity<>(dogService.getDogById(dogId), HttpStatus.ACCEPTED);
    }

    @PutMapping("{dogId}")
    public ResponseEntity updateDog(@PathVariable Long dogId, @RequestBody Dog dog){
        Dog existingDog = dogService.getDogById(dogId);
        BeanUtils.copyProperties(dog, existingDog, "id");
        dogService.saveDog(existingDog);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
