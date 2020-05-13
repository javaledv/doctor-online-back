package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.DoctorSpecialization;
import com.university.doctoronline.entity.DoctorSpecializationLocalizedName;
import com.university.doctoronline.repository.DoctorSpecializationLocalizedNameRepository;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.service.DoctorSpecializationLocalizedNameService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorSpecializationLocalizedNameServiceImpl extends AbstractBaseCrudService<DoctorSpecializationLocalizedName, IdSearchCriteria> implements DoctorSpecializationLocalizedNameService {

    private final DoctorSpecializationLocalizedNameRepository repository;

    public DoctorSpecializationLocalizedNameServiceImpl(DoctorSpecializationLocalizedNameRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<DoctorSpecializationLocalizedName> getAllBy(String locale) {
        final var allByLocale = repository.getAllByLocale(locale);
        if (CollectionUtils.isEmpty(allByLocale)) {
            // TODO change for using app property
            return repository.getAllByLocale("ru");
        }
        return allByLocale;
    }

    @Override
    public Optional<DoctorSpecializationLocalizedName> getBy(String locale, DoctorSpecialization doctorSpecialization) {
        final var specialization = repository.getByLocaleAndDoctorSpecialization(locale, doctorSpecialization);
        if (specialization.isEmpty()) {
            return repository.getByLocaleAndDoctorSpecialization("ru", doctorSpecialization);
        }
        return specialization;
    }

    @Override
    public Specification<DoctorSpecializationLocalizedName> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }
}
