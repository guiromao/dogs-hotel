package com.dogshotel.mappers;

import com.dogshotel.models.Owner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OwnerMapper {

    @Select("SELECT * FROM owners WHERE id >= #{id}")
    List<Owner> getIdHigherThan(@Param("id") Long id);

}
