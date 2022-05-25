package com.doggy.models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Dog {
    private static AtomicInteger idGenerator = new AtomicInteger(1);
    private int id;
    private String name;
    private int age;
    private String gender;
    private Owner owner;

    private List<Allergy> allergies;

    public Dog() {
    }

    public Dog(String name, int age, String gender, List<Allergy> allergies, Owner owner) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.owner = owner;
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

