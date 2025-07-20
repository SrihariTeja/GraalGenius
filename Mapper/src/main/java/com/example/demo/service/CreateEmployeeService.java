package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeInterface;

@Service
public class CreateEmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(CreateEmployeeService.class);

    private final EmployeeInterface empinterface;

    @Autowired
    public CreateEmployeeService(EmployeeInterface empinterface) {
        this.empinterface = empinterface;
    }

    public EmployeeDto saveEmployee(EmployeeDto empl) {
        logger.info("Attempting to save employee: {}", empl);
        
        Employee emp = new Employee();
        if(empl.getId()!=0)
         emp = empinterface.findById(empl.getId()).orElseThrow(null);

         emp = EmployeeMapper.mapToEmployee(empl);
        Employee savedEmployee = empinterface.save(emp);

        EmployeeDto result = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        logger.info("Successfully saved employee with ID: {}", result.getId());

        return result;
    }
    public EmployeeDto getEmployeeById(Long id) {
    	
    	Employee emp = empinterface.getById(id);
    	EmployeeDto emp1 = EmployeeMapper.mapToEmployeeDto(emp);
        logger.info("The Employee Details by ID is:::{}" ,emp1);

    	return emp1;
    }
    public List<EmployeeDto> getAllEmployees() {
    	
    	List<Employee> empList = empinterface.findAll();
        logger.info("The total number of employees are:::" ,empList.size());

    	List<EmployeeDto> empDtoList = new ArrayList<>();
    	empDtoList = empList.stream().map(emp -> EmployeeMapper.mapToEmployeeDto(emp))
    			.collect(Collectors.toList());
    	

    	return empDtoList;
    }
    public boolean deleteEmployee(Long id) {
    	try {
    	 empinterface.deleteById(id);
    	 return true;
    }
    	catch(Exception e) {
    		System.out.printf("Error while deleting the id",e);
    		return false;
    	}
     
}
    @Deprecated
    public String getInfo(Object request) {
    	try {
    	RestTemplate rest = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Content-Type", "application/xml");
    	ResponseEntity<String> response=rest.postForEntity("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyCzejMAgonnqevsU8DCtA_8xC314-KeRlk", request, String.class);
    	JSONObject js = new JSONObject(response.getBody());
    	System.out.println("The statuse codes are:::"+response.getStatusCodeValue());
    	String finalRes=js.optJSONArray("candidates").optJSONObject(0).optJSONObject("content").optJSONArray("parts").optJSONObject(0).optString("text");
    	System.out.println(finalRes);
    	return finalRes;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return e.getMessage();
    	}
    }
}
