package com.example.demo.Qualification.controller;

import com.example.demo.Qualification.model.Qualification;

public class QualificationDto {
    private final long id;
    private final String name;

    public QualificationDto(Qualification qualification) {
        this.id = qualification.getId();
        this.name = String.format("%s %s", qualification.getCategory(), qualification.getName());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
