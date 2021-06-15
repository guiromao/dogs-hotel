package com.dogshotel.services;

import com.dogshotel.models.Dog;

import java.util.List;

public interface DogService {

    List<Dog> listDogs();

    Dog getDogById(Long id);

    Dog saveDog(Dog dog);

    void deleteDog(Long id);

}
