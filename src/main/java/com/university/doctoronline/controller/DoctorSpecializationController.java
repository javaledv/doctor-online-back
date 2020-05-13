package com.university.doctoronline.controller;

import com.university.doctoronline.dto.DoctorSpecializationDto;
import com.university.doctoronline.dto.converter.DoctorSpecializationLocalizedNameDtoConverter;
import com.university.doctoronline.entity.DoctorSpecialization;
import com.university.doctoronline.exception.NotFoundException;
import com.university.doctoronline.service.DoctorSpecializationLocalizedNameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor-specialization")
public class DoctorSpecializationController {

    private final DoctorSpecializationLocalizedNameService doctorSpecializationLocalizedNameService;
    private final DoctorSpecializationLocalizedNameDtoConverter doctorSpecializationLocalizedNameDtoConverter;

    public DoctorSpecializationController(DoctorSpecializationLocalizedNameService doctorSpecializationLocalizedNameService, DoctorSpecializationLocalizedNameDtoConverter doctorSpecializationLocalizedNameDtoConverter) {
        this.doctorSpecializationLocalizedNameService = doctorSpecializationLocalizedNameService;
        this.doctorSpecializationLocalizedNameDtoConverter = doctorSpecializationLocalizedNameDtoConverter;
    }

    @GetMapping("/all")
    public List<DoctorSpecializationDto> getAll(Locale locale) {
        return doctorSpecializationLocalizedNameService.getAllBy(locale.getLanguage()).stream()
                .map(doctorSpecializationLocalizedNameDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    public DoctorSpecializationDto byId(Locale locale, @RequestParam(name = "id") DoctorSpecialization doctorSpecialization) {
        return doctorSpecializationLocalizedNameService.getBy(locale.getLanguage(), doctorSpecialization)
                .map(doctorSpecializationLocalizedNameDtoConverter::toDto)
                .orElseThrow(NotFoundException::new);
    }
}
