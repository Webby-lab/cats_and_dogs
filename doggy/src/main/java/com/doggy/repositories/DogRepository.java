package com.doggy.repositories;

import com.doggy.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DogRepository {
    Owner geza = new Owner("Géza");
    Owner eszter = new Owner("Eszter");

//    Dog pityu = new Dog("Pityu", 3, "fiú", Arrays.asList(Allergy.GYÓGYSZER), geza);
//    Dog piri = new Dog("Piri", 13, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.TISZTÍTÓ_TERMÉKEK), geza);
//    Dog piros = new Dog("Piroska", 1, "lány", Arrays.asList(Allergy.BŐR, Allergy.NÖVÉNY), eszter);
//    Dog lajos = new Dog("Lajos", 6, "fiú", Arrays.asList(Allergy.ÉLELMISZER, Allergy.NÖVÉNY), eszter);
//    Dog kati = new Dog("Katika", 11, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.NÖVÉNY, Allergy.ÉLELMISZER), geza);
    public static List<Dog> dogs = Arrays.asList(
            new Dog("Pityu", 3, "fiú", Arrays.asList(Allergy.GYÓGYSZER)),
            new Dog("Piroska", 1, "lány", Arrays.asList(Allergy.BŐR, Allergy.NÖVÉNY)),
        new Dog("Lajos", 6, "fiú", Arrays.asList(Allergy.ÉLELMISZER, Allergy.NÖVÉNY)),
        new Dog("Katika", 11, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.NÖVÉNY, Allergy.ÉLELMISZER)));
    public static List<Dog> getAll() {
        return dogs;
    }

    public static Dog getById(int id) {
        return dogs.stream().filter((Dog d)-> d.getId() == id).findFirst().get();
    }

    public static List<Dog> getByName(String name) {
        return dogs.stream()
                .filter(d -> d.getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public static void register(Dog dog) {
        dogs.add(dog);
    }

}
