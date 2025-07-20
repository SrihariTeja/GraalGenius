package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Component
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto empdto) {
        return new Employee(
                empdto.getId(),
                empdto.getFirstName(),
                empdto.getLastName(),
                empdto.getEmail()
        );
    }
}
