package com.dogshotel;

import com.dogshotel.models.Dog;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;

@MappedTypes(Dog.class)
@MapperScan("com.dogshotel.mappers")
@SpringBootApplication
@EnableCaching
public class DogshotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogshotelApplication.class, args);
	}

}
