package com.university.doctoronline.controller;

import com.university.doctoronline.dto.DoctorDto;
import com.university.doctoronline.dto.converter.DoctorDtoConverter;
import com.university.doctoronline.search.DoctorSearchCriteria;
import com.university.doctoronline.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorDtoConverter converter;

    public DoctorController(DoctorService doctorService, DoctorDtoConverter converter) {
        this.doctorService = doctorService;
        this.converter = converter;
    }

    @GetMapping("/list")
    public Page<DoctorDto> list(@Valid DoctorSearchCriteria searchCriteria, @PageableDefault(size = 5) Pageable pageable, Locale locale) {
        return doctorService.getPage(searchCriteria, pageable).map(doctor -> converter.toDto(doctor, locale.getLanguage()));
    }
}
