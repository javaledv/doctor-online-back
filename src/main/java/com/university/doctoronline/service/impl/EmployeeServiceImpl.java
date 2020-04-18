package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;
import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.employee.Employee;
import com.university.doctoronline.filter.IdFilter;
import com.university.doctoronline.repository.EmployeeRepository;
import com.university.doctoronline.service.EmployeeService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl extends AbstractBaseCrudService<Employee, IdFilter> implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Example<Employee> createExample(BaseFilter filter) {
        return null;
    }

    @Override
    public Optional<Employee> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
