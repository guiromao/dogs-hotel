package com.dogshotel.services;

import com.dogshotel.models.Dog;
import com.dogshotel.models.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService {

    List<Owner> listOwners();

    Owner getById(Long id);

    Owner saveOwner(Owner owner);

    void deleteOwner(Long id);

    void deleteAll();

}
