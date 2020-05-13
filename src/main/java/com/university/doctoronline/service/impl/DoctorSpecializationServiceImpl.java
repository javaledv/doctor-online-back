package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.DoctorSpecialization;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.repository.DoctorSpecializationRepository;
import com.university.doctoronline.service.DoctorSpecializationService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DoctorSpecializationServiceImpl extends AbstractBaseCrudService<DoctorSpecialization, IdSearchCriteria> implements DoctorSpecializationService {

    private final DoctorSpecializationRepository repository;

    public DoctorSpecializationServiceImpl(DoctorSpecializationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Specification<DoctorSpecialization> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }
}
