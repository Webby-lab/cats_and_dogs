package com.doggy.services;

import com.doggy.models.Allergy;
import com.doggy.models.Appointment;
import com.doggy.models.Dog;
import com.doggy.repositories.AppointmentsRepository;
import com.doggy.repositories.DogRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.doggy.repositories.DogRepository.dogs;

public class DogService {

    public static List<Dog> sortedDogs(String sortedBy, Boolean isAsc) {
        List<Dog> dogs = DogRepository.getAll();
        if ("name".equals(sortedBy)) {
            return dogs.stream()
                    .sorted((d1, d2) -> isAsc ? d1.getName().compareTo(d2.getName()) : d2.getName().compareTo(d1.getName()))
                    .collect(Collectors.toList());
        } else if ("age".equals(sortedBy)) {
            return dogs.stream()
                    .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                    .collect(Collectors.toList());
        } else {
            return dogs;
        }

    }
public static List<Dog> filterByAllargies(List<Dog> dogs, Allergy allergy) {
        if (allergy == null) return dogs;
        return dogs.stream()
                .filter(d ->
                        d.getAllergies().contains(allergy))
                .collect(Collectors.toList());
}
public static List<Dog> getAll() {
        return DogRepository.getAll();
}
public static Appointment newAppointment() {
        List<Appointment> appointments = AppointmentsRepository.getAll();
        Appointment newAppointment = appointments.get(appointments.size()-1);
        return newAppointment != null ? newAppointment : new Appointment();
}

}
