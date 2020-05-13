package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.DoctorSpecializationDto;
import com.university.doctoronline.entity.DoctorSpecializationLocalizedName;
import org.springframework.stereotype.Service;

@Service
public class DoctorSpecializationLocalizedNameDtoConverter implements DtoConverter<DoctorSpecializationLocalizedName, DoctorSpecializationDto> {

    @Override
    public DoctorSpecializationLocalizedName toEntity(DoctorSpecializationDto dto) {
        return null;
    }

    @Override
    public DoctorSpecializationDto toDto(DoctorSpecializationLocalizedName entity) {
        final var dto = new DoctorSpecializationDto();
        dto.setId(entity.getDoctorSpecialization().getId());
        dto.setCode(entity.getDoctorSpecialization().getCode());
        dto.setLocalizedName(entity.getName());

        return dto;
    }
}
