package com.dogshotel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="dogs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date birthDate;
    private String breed;
    private char gender;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public Dog(){

    }

    public Dog(String name, Date birthDate, String breed, char gender){
        this.name = name;
        this.birthDate = birthDate;
        this.breed = breed;
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Dog: " + name + ", breed: " + breed + ", gender: " + gender + ".";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBreed() {
        return breed;
    }

    public char getGender() {
        return gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
