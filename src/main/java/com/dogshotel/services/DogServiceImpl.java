package com.dogshotel.services;

import com.dogshotel.models.Dog;
import com.dogshotel.repositories.DogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> listDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Dog getDogById(Long id) {
        return dogRepository.getById(id);
    }

    @Override
    public Dog saveDog(Dog dog) {
        return dogRepository.saveAndFlush(dog);
    }

    @Override
    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }

}
