package com.dogshotel.services;

import com.dogshotel.exceptions.OwnerNotFoundException;
import com.dogshotel.models.Dog;
import com.dogshotel.models.Owner;
import com.dogshotel.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> listOwners() {
        return ownerRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "owners", key = "#id")
    public Owner getById(Long id) {
        System.out.println("Did not go to cache to fetch one owner");
        return ownerRepository.getById(id);
    }

    @Override
    @CachePut(cacheNames="owners")
    public Owner saveOwner(Owner owner){
        return ownerRepository.saveAndFlush(owner);
    }


    @Override
    @CacheEvict(cacheNames="owners", key="#id")
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        ownerRepository.deleteAll();
    }

}
