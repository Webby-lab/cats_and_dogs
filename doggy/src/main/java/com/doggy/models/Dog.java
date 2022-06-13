package com.doggy.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Dog {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private int id;
    private String name;
    private int age;
    private String gender;
    private Owner owner;
    private int social;
    private List<Allergy> allergies;

    public Dog() {
        this.id = idGenerator.getAndIncrement();
    }

    public Dog(String name, int age, String gender, int social, List<Allergy> allergies) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.social = social;
        this.allergies = allergies;
    }

    public Dog(String name, int age, String gender) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;

    }
    public Dog(String name, int age, String gender, List<Allergy> allergies) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.allergies = allergies;
    }


    public Dog(String name, int age, String gender, List<Allergy> allergies, Owner owner) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.owner = owner;
        this.allergies = allergies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public AtomicInteger getIdGenerator() {
        return idGenerator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }


}

