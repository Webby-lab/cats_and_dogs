package com.doggy.controllers;

import com.doggy.models.*;
import com.doggy.repositories.DogRepository;
import com.doggy.services.AppointmentService;
import com.doggy.services.DogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DogController {
//    Owner geza = new Owner("Géza");
//    Owner eszter = new Owner("Eszter");
//    public static List<Dog> dogs = new ArrayList<>();
//    Dog pityu = new Dog("Pityu", 3, "fiú", Arrays.asList(Allergy.GYÓGYSZER), geza);
//    Dog piri = new Dog("Piri", 13, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.TISZTÍTÓ_TERMÉKEK), geza);
//    Dog piros = new Dog("Piroska", 1, "lány", Arrays.asList(Allergy.BŐR, Allergy.NÖVÉNY), eszter);
//    Dog lajos = new Dog("Lajos", 6, "fiú", Arrays.asList(Allergy.ÉLELMISZER, Allergy.NÖVÉNY), eszter);
//    Dog kati = new Dog("Katika", 11, "lány", Arrays.asList(Allergy.GYÓGYSZER, Allergy.NÖVÉNY, Allergy.ÉLELMISZER), geza);



    @GetMapping("/dogs")
    public String renderDogsPage(
            Model model,
            @RequestParam(value = "sort", required = false) String sortedBy,
            @RequestParam(required=false) Boolean asc,
            @RequestParam(required = false) Allergy allergy){
        List<Dog> dogs = DogService.sortedDogs(sortedBy, asc);
        List<Dog> filteredDogs = DogService.filterByAllargies(dogs, allergy );
        model.addAttribute("dogs", filteredDogs);
        return "dogs";
    }

    @GetMapping("/dogs/{id}")
    public String renderProfilePage(Model model, @PathVariable(value = "id") Integer id) {

        model.addAttribute("dog", DogRepository.getById(id));
        return "dogsProfilePage";
    }

    @PostMapping("/dogs")
    public String renderDogsSearchedPage(Model model, @RequestParam String search) {
        List<Dog> dogs = DogRepository.getByName(search);
        model.addAttribute("dogs", dogs);

        return "dogs";
    }

    @GetMapping("/registration")
    public String renderRegistrationPage(Model model) {
        List<Allergy> allergies = Arrays.asList(Allergy.values());
        model.addAttribute("allergies", allergies);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerAnimal(@ModelAttribute Dog dog) {
        DogRepository.register(dog);
        return "redirect:/dogs";
    }

    @GetMapping("/appointment")
    public String renderNewAppointmentPage(Model model) {
        model.addAttribute("dogs", DogService.getAll());
        model.addAttribute("treatments", Treatment.values());
        model.addAttribute("appointments", AppointmentService.getAll());
        return "newAppointment";
    }

    @PostMapping("/appointment")
    public String saveNewAppointment(@ModelAttribute Appointment appointment) {
        AppointmentService.saveOrModify(appointment);
    return "redirect:/appointment";
    }

    @GetMapping("/appointment/{id}")
    public String renderModifyAppointmentPage(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", AppointmentService.getById(id) );
        model.addAttribute("dogs", DogService.getAll());
        model.addAttribute("treatments", Treatment.values());
        model.addAttribute("appointments", AppointmentService.getAll());
        return "newAppointment";
    }
}

