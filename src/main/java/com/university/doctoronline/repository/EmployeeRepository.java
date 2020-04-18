package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.employee.Employee;

import java.util.Optional;

public interface EmployeeRepository extends BaseCrudRepository<Employee> {

    Optional<Employee> findByEmail(String email);
}
