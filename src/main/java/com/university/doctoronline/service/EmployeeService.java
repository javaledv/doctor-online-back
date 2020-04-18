package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.employee.Employee;
import com.university.doctoronline.filter.IdFilter;

import java.util.Optional;

public interface EmployeeService extends BaseCrudService<Employee, IdFilter> {

    Optional<Employee> getByEmail(String email);
}
