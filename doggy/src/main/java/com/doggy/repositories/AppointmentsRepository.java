package com.doggy.repositories;

import com.doggy.models.Appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentsRepository {
    private static List<Appointment> appointments = new ArrayList<>();
    public static List<Appointment> getAll() {
        return appointments;
    }
    public static Appointment getById(long id) {
       return appointments.stream()
                .filter(a -> a.getId() ==id)
               .findFirst()
               .orElse(null);
    }
    public static void create (Appointment appointment) {
        appointments.add(appointment);
    }
    public static void modify(Appointment modified) {
        Appointment appointment = getById(modified.getId());
        if (appointment == null) {
            return;
        }
        appointment.setDogId(modified.getDogId());
        appointment.setTime(modified.getTime());
        appointment.setTreatment(modified.getTreatment());
        appointment.setStay(modified.getIsStay());
    }
}
