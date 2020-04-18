package com.university.doctoronline.dto.converter;

import com.university.doctoronline.dto.EmployeeDto;
import com.university.doctoronline.entity.employee.Employee;
import com.university.doctoronline.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDtoConverter implements DtoConverter<Employee, EmployeeDto> {

    private final EmployeeService employeeService;

    public EmployeeDtoConverter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee toEntity(EmployeeDto dto) {
        return employeeService.getById(dto.getId()).orElseThrow(() -> new RuntimeException("Employee not found!"));
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        final var dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setRoles(entity.getRoles());

        //TODO implement isActive
        dto.setActive(false);
        return dto;
    }
}
