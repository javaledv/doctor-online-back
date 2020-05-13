package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.DoctorDto;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.exception.NotFoundException;
import com.university.doctoronline.service.DoctorSpecializationLocalizedNameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DoctorDtoConverter implements DtoConverter<Doctor, DoctorDto> {

    private final DoctorSpecializationLocalizedNameService doctorSpecializationLocalizedNameService;
    private final DoctorSpecializationLocalizedNameDtoConverter doctorSpecializationLocalizedNameDtoConverter;

    public DoctorDtoConverter(DoctorSpecializationLocalizedNameService doctorSpecializationLocalizedNameService, DoctorSpecializationLocalizedNameDtoConverter doctorSpecializationLocalizedNameDtoConverter) {
        this.doctorSpecializationLocalizedNameService = doctorSpecializationLocalizedNameService;
        this.doctorSpecializationLocalizedNameDtoConverter = doctorSpecializationLocalizedNameDtoConverter;
    }

    @Override
    public Doctor toEntity(DoctorDto dto) {
        return null;
    }

    @Override
    public DoctorDto toDto(Doctor entity) {
        final var dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setCabinet(entity.getCabinet());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());

        return dto;
    }

    public DoctorDto toDto(Doctor entity, String locale) {
        final var dto = toDto(entity);
        final var specialization = entity.getDoctorSpecialization()
                .getDoctorSpecializationLocalizedNames()
                .stream()
                .filter(name -> StringUtils.equals(locale, name.getLocale()))
                .findFirst()
                .orElseGet(() -> doctorSpecializationLocalizedNameService.getBy("ru", entity.getDoctorSpecialization()).orElseThrow(NotFoundException::new));

        dto.setDoctorSpecialization(doctorSpecializationLocalizedNameDtoConverter.toDto(specialization));
        return dto;
    }
}
