package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.DoctorSpecialization;
import com.university.doctoronline.entity.DoctorSpecializationLocalizedName;

import java.util.List;
import java.util.Optional;

public interface DoctorSpecializationLocalizedNameRepository extends BaseCrudRepository<DoctorSpecializationLocalizedName> {

    List<DoctorSpecializationLocalizedName> getAllByLocale(String locale);

    Optional<DoctorSpecializationLocalizedName> getByLocaleAndDoctorSpecialization(String locale, DoctorSpecialization doctorSpecialization);
}
