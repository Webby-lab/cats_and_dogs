package com.doggy.services;

import com.doggy.models.Appointment;
import com.doggy.repositories.AppointmentsRepository;

import java.util.List;

public class AppointmentService {

    public static List<Appointment> getAll() {
        return AppointmentsRepository.getAll();
    }
    public static void save(Appointment appointment) {
        AppointmentsRepository.create(appointment);
    }
    public static Appointment getById(Long id) {
        return AppointmentsRepository.getById(id);
    }
    public static void modify(Appointment appointment) {
        AppointmentsRepository.modify(appointment);
    }
    public static void saveOrModify(Appointment appointment) {
        if (AppointmentsRepository.getById(appointment.getId()) == null) {
            save(appointment);
        }else {
            modify(appointment);
        }
    }
}
