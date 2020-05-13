package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.search.DoctorSearchCriteria;
import com.university.doctoronline.search.IdSearchCriteria;

public interface DoctorService extends BaseCrudService<Doctor, DoctorSearchCriteria> {
}
