package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.user.Patient;

import java.util.Optional;

public interface PatientRepository extends BaseCrudRepository<Patient> {

    Optional<Patient> getByEmail(String email);
}
