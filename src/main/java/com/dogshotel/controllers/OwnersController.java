package com.dogshotel.controllers;

import com.dogshotel.mappers.OwnerMapper;
import com.dogshotel.models.Dog;
import com.dogshotel.models.Owner;
import com.dogshotel.services.OwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/owners")
public class OwnersController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerMapper ownerMapper;

    @GetMapping({"/", ""})
    public ResponseEntity<List<Owner>> listOwners(){
        List<Owner> owners = new ArrayList<>();

        owners = ownerService.listOwners();

        return new ResponseEntity<>(owners, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id){
        Owner owner = ownerService.getById(id);
        return new ResponseEntity<>(owner, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/dogs")
    public ResponseEntity<Set<Dog>> getDogsByOwner(@PathVariable Long id){
        Owner owner = ownerService.getById(id);

        return new ResponseEntity<>(owner.getDogs(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/ids")
    public ResponseEntity<List<Owner>> getOwnersHigherThanId(@RequestParam Long minimId){
        return new ResponseEntity<>(ownerMapper.getIdHigherThan(minimId), HttpStatus.ACCEPTED);
    }

    @PostMapping({"/", ""})
    public ResponseEntity createOwner(@RequestBody Owner owner){
        ownerService.saveOwner(owner);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOwner(@PathVariable Long id, @RequestBody Owner owner){
        Owner existingOwner = ownerService.getById(id);
        Set<Dog> ownedDogs = existingOwner.getDogs();
        BeanUtils.copyProperties(owner, existingOwner, "id");
        owner.setDogs(ownedDogs);
        ownerService.saveOwner(existingOwner);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/{ownerId}/dogs")
    public ResponseEntity addDogToOwner(@PathVariable Long ownerId, @RequestBody Dog dog){
        Owner owner = ownerService.getById(ownerId);
        owner.addDog(dog);
        dog.setOwner(owner);
        owner.printDogs();
        ownerService.saveOwner(owner);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/owners")
    public ResponseEntity deleteAllOwners(){
        ownerService.deleteAll();

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
