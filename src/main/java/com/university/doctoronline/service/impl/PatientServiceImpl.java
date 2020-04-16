package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;
import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.employee.Patient;
import com.university.doctoronline.filter.IdFilter;
import com.university.doctoronline.repository.PatientRepository;
import com.university.doctoronline.service.PatientService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends AbstractBaseCrudService<Patient, IdFilter> implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Example<Patient> createExample(BaseFilter baseFilter) {
        return null;
    }
}
