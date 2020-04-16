package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.employee.Patient;
import com.university.doctoronline.filter.IdFilter;

public interface PatientService extends BaseCrudService<Patient, IdFilter> {
}
