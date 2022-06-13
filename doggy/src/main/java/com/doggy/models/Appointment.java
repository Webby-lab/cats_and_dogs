package com.doggy.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
    private static AtomicLong idGenerator = new AtomicLong(1);



    private long id = idGenerator.getAndIncrement();
    private Integer dogId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private Treatment treatment;
    private Boolean isStay;


    public Appointment() {
    }

    public Appointment(Integer dogId, LocalDateTime time, Treatment treatment, Boolean isStay) {
        this.dogId = dogId;
        this.time = time;
        this.treatment = treatment;
        this.isStay = isStay;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getIsStay() {
        return isStay;
    }

    public void setIsStay(Boolean stay) {
        isStay = stay;
    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public static AtomicLong getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(AtomicLong idGenerator) {
        Appointment.idGenerator = idGenerator;
    }

    public Boolean getStay() {
        return isStay;
    }

    public void setStay(Boolean stay) {
        isStay = stay;
    }
}
