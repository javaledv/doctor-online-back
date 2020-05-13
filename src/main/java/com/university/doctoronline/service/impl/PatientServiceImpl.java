package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.search.IdSearchCriteria;
import com.university.doctoronline.repository.PatientRepository;
import com.university.doctoronline.service.PatientService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl extends AbstractBaseCrudService<Patient, IdSearchCriteria> implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Patient> getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Specification<Patient> createSpecification(IdSearchCriteria searchCriteria) {
        return null;
    }
}
