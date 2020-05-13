package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.user.Doctor;
import com.university.doctoronline.repository.DoctorRepository;
import com.university.doctoronline.search.DoctorSearchCriteria;
import com.university.doctoronline.service.DoctorService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;

import static com.university.doctoronline.utils.SpecificationUtils.join;

@Service
public class DoctorServiceImpl extends AbstractBaseCrudService<Doctor, DoctorSearchCriteria> implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Specification<Doctor> createSpecification(DoctorSearchCriteria searchCriteria) {
        final Specification<Doctor> idPredicate = (root, query, builder) -> {
            final var id = searchCriteria.getId();
            if (id == null) {
                return null;
            }

            return builder.equal(root.get("id"), id);
        };

        final Specification<Doctor> specializationPredicate = (root, query, builder) -> {
            final var specializationId = searchCriteria.getSpecializationId();
            if (specializationId == null) {
                return null;
            }

            return builder.equal(join(root, "doctorSpecialization", JoinType.INNER).get("id"), specializationId);
        };

        return Specification.where(idPredicate).and(specializationPredicate);
    }


}
