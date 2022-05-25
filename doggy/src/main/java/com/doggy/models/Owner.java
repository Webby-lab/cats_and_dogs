package com.doggy.models;

public class Owner {
    private String name;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
