package com.doggy.controllers;

import com.doggy.models.Allergy;
import com.doggy.models.Dog;
import com.doggy.models.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class DogController {
    Owner geza = new Owner("Géza");
    Owner eszter = new Owner("Eszter");
    List<Dog> dogs = Arrays.asList(
            new Dog("Pityu", 3, "fiú", Arrays.asList(Allergy.GYÓGYSZER), geza),
            new Dog("Piri", 13, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.TISZTÍTÓ_TERMÉKEK), geza),
            new Dog("Piroska", 1, "lány", Arrays.asList(Allergy.BŐR, Allergy.NÖVÉNY), eszter),
            new Dog("Lajos", 6, "fiú", Arrays.asList(Allergy.ÉLELMISZER, Allergy.NÖVÉNY), eszter),
            new Dog("Katika", 11, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.NÖVÉNY, Allergy.ÉLELMISZER), geza)
    );


    @GetMapping("/dogs")
    public String renderDogsPage(Model model) {
        model.addAttribute("dogs", dogs);
        model.addAttribute("owner", geza);

        return "dogs";
    }
    @GetMapping("/dogs/{id}")
    public String renderProfilePage(Model model, @PathVariable(value = "id") Integer id) {
        Dog dog = dogs.stream().filter((Dog d)-> d.getId() == id).findFirst().get();
        model.addAttribute("dog", dog);
        return "dogsProfilePage";
    }
    @GetMapping("/registration")
    public String renderRegistrationPage() {
        return "registration";
    }
}

