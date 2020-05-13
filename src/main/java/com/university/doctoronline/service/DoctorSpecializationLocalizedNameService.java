package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.DoctorSpecialization;
import com.university.doctoronline.entity.DoctorSpecializationLocalizedName;
import com.university.doctoronline.search.IdSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface DoctorSpecializationLocalizedNameService extends BaseCrudService<DoctorSpecializationLocalizedName, IdSearchCriteria> {

    List<DoctorSpecializationLocalizedName> getAllBy(String locale);

    Optional<DoctorSpecializationLocalizedName> getBy(String locale, DoctorSpecialization doctorSpecialization);
}
