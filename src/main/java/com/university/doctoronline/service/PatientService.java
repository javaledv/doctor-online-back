package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.user.Patient;
import com.university.doctoronline.filter.IdFilter;

import java.util.Optional;

public interface PatientService extends BaseCrudService<Patient, IdFilter> {

    Optional<Patient> getByEmail(String email);
}
