package com.university.doctoronline.dto.converter;


import com.university.doctoronline.dto.PatientDto;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.entity.user.Role;
import com.university.doctoronline.repository.RoleRepository;
import com.university.doctoronline.service.PatientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class PatientDtoConverter implements DtoConverter<Patient, PatientDto> {

    private final PatientService patientService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressDtoConverter addressDtoConverter;

    public PatientDtoConverter(PatientService patientService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AddressDtoConverter addressDtoConverter) {
        this.patientService = patientService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressDtoConverter = addressDtoConverter;
    }

    @Override
    public Patient toEntity(PatientDto dto) {
        final var patient = dto.getId() == null ? new Patient() :
                patientService.getById(dto.getId()).orElseGet(Patient::new);

        if (dto.getPassword() != null) {
            patient.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getEmail() != null) {
            patient.setEmail(dto.getEmail());
        }

        if (patient.getId() == null) {
            final var roles = new HashSet<Role>();
            roles.add(roleRepository.getByName("ROLE_PATIENT"));
            patient.setRoles(roles);
        } else {
            patient.setActive(true);
        }

        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setMiddleName(dto.getMiddleName());
        patient.setAddress(addressDtoConverter.toEntity(dto.getAddress()));
        patient.setBirthDate(dto.getBirthday());
        patient.setGender(dto.getGender());
        patient.setPhoneNumber(dto.getPhoneNumber());

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
        dto.setAddress(addressDtoConverter.toDto(entity.getAddress()));
        dto.setBirthday(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setActive(entity.isActive());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }
}
