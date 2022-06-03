package com.doggy.models;

import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
    private static AtomicLong idGenerator = new AtomicLong(1);
    private long id = idGenerator.getAndIncrement();
    private Integer dogId;
    private Treatment treatment;


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
}
