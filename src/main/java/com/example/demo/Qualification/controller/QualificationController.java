package com.example.demo.Qualification.controller;

import com.example.demo.Qualification.model.Collector;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Qualification.service.QualificationService;

import java.util.List;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
    private final QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping("/{id}")
    public QualificationDto getQualification(@PathVariable Long id) {
        return new QualificationDto(qualificationService.findQualification(id));
    }

    @GetMapping("/")
    public List<QualificationDto> getQualifications() {
        return qualificationService.findAllQualifications().stream().map(QualificationDto::new).toList();
    }

    @PostMapping("/")
    public QualificationDto createQualification(@RequestParam("category") int category,
                                          @RequestParam("name") String name) {
        return new QualificationDto(qualificationService.addQualification(category, name));
    }

    @PutMapping("/{id}")
    public QualificationDto updatQualification(@PathVariable Long id,
                                          @RequestParam("category") int category,
                                          @RequestParam("name") String name) {
        return new QualificationDto(qualificationService.updateQualification(id, category, name));
    }

    @DeleteMapping("/{id}")
    public QualificationDto deleteQualification(@PathVariable Long id) {
        return new QualificationDto(qualificationService.deleteQualification(id));
    }
}