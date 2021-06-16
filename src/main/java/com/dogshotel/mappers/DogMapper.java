package com.dogshotel.mappers;

import com.dogshotel.models.Dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DogMapper {

    @Select("SELECT * FROM dogs WHERE name = #{name}")
    List<Dog> findDogByName(@Param("name") String name);

}
