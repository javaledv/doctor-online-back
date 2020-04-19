package com.university.doctoronline.dto.converter;


import com.university.doctoronline.dto.PatientDto;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.repository.RoleRepository;
import com.university.doctoronline.service.PatientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PatientDtoConverter implements DtoConverter<Patient, PatientDto> {

    private final PatientService patientService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public PatientDtoConverter(PatientService patientService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.patientService = patientService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Patient toEntity(PatientDto dto) {
        final var patient = dto.getId() == null ? new Patient() :
                patientService.getById(dto.getId()).orElseGet(Patient::new);

        if (dto.getPassword() != null) {
            patient.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        patient.setEmail(dto.getEmail());
        patient.setRoles(Set.of(roleRepository.getByName("ROLE_PATIENT")));
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setMiddleName(dto.getMiddleName());
        patient.setAddress(dto.getAddress());
        patient.setBirthDate(dto.getBirthDate());
        patient.setGender(dto.getGender());

        return patient;
    }

    @Override
    public PatientDto toDto(Patient entity) {
        final var dto = new PatientDto();

        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setRoles(entity.getRoles());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setActive(entity.isActive());

        return dto;
    }
}
