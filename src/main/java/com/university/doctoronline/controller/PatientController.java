package com.university.doctoronline.controller;


import com.university.doctoronline.dto.PatientDto;
import com.university.doctoronline.dto.converter.PatientDtoConverter;
import com.university.doctoronline.exception.UserAlreadyExistException;
import com.university.doctoronline.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final PatientDtoConverter patientDtoConverter;

    public PatientController(PatientService patientService, PatientDtoConverter patientDtoConverter) {
        this.patientService = patientService;
        this.patientDtoConverter = patientDtoConverter;
    }

    @GetMapping("/all")
    public List<PatientDto> getAll() {
        return patientService.getAll().stream()
                .map(patientDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public PatientDto create(@RequestBody PatientDto patientDto) {
        if (patientService.getByEmail(patientDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        return patientDtoConverter.toDto(patientService.save(patientDtoConverter.toEntity(patientDto)));
    }

    @PostMapping("/save")
    public PatientDto save(@RequestBody PatientDto patientDto) {
        return patientDtoConverter.toDto(patientService.save(patientDtoConverter.toEntity(patientDto)));
    }
}
