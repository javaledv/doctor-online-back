package com.university.doctoronline.dto.converter;


import com.university.doctoronline.dto.PatientDto;
import com.university.doctoronline.entity.employee.Patient;
import com.university.doctoronline.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientDtoConverter implements DtoConverter<Patient, PatientDto> {

    private final PatientService patientService;

    public PatientDtoConverter(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public Patient toEntity(PatientDto dto) {
        final var patient = dto.getId() == null ? new Patient() :
                patientService.getById(dto.getId()).orElseGet(Patient::new);

        patient.setFirstName(dto.getFirstName());
        patient.setPassword(dto.getPassword());
        patient.setLastName(dto.getLastName());
        patient.setMiddleName(dto.getMiddleName());
        patient.setAddress(dto.getAddress());
        patient.setBirthDate(dto.getBirthDate());
        patient.setGender(dto.getGender());
        patient.setLogin(dto.getLogin());

        return patient;
    }

    @Override
    public PatientDto toDto(Patient entity) {
        final var dto = new PatientDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setLogin(entity.getLogin());

        return dto;
    }
}
