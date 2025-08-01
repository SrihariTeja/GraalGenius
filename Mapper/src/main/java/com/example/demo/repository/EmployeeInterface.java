package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee, Long>{
	
	
}
