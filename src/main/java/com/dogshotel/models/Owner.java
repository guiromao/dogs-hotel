package com.dogshotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="owners")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Dog> dogs;

    public Owner(){

    }

    public Owner(String name, String contact){
        this.name = name;
        this.contact = contact;
    }

    public void addDog(Dog dog){
        dogs.add(dog);
    }

    public void printDogs(){
        String result = "";
        for(Dog dog: dogs) {
            result += dog.toString() + "\n";
        }

        System.out.println(result);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
