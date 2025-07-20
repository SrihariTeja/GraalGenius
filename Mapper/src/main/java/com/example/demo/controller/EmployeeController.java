package com.example.demo.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.CreateEmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	CreateEmployeeService service;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dt) {
		EmployeeDto savedone =service.saveEmployee(dt);
		return  new ResponseEntity<>(savedone,HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
		//Long id = (long) id1;
		System.out.println("The value of long is ::"+id);
		EmployeeDto savedone =service.getEmployeeById(id);
		return  new ResponseEntity<>(savedone,HttpStatus.OK);
		
	}
	
	@PostMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployee1(@PathVariable("id") Long id) {
		//Long id = (long) id1;
		System.out.println("The value of long is ::"+id);
		EmployeeDto savedone =service.getEmployeeById(id);
		return  new ResponseEntity<>(savedone,HttpStatus.OK);
		
	}
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDto>> getEmployee() {
		//Long id = (long) id1;
		//System.out.println("The value of long is ::"+id);
		List<EmployeeDto> AllEmployees =service.getAllEmployees();
		return  new ResponseEntity<>(AllEmployees,HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public List<EmployeeDto> geteteEmployeeById(@PathVariable("id") Long id) {
		if(service.deleteEmployee(id)) {
			List<EmployeeDto> AllEmployees =service.getAllEmployees();
			return AllEmployees ;
		}
		else
			return null;
		
	}

	@PostMapping("/geminiAI")
	public ResponseEntity<String> getInfoFromAI(@RequestBody Object request,HttpServletRequest req) {
		JSONObject js = new JSONObject();
		
		System.out.println("The headers are::::"+req.getHeaderNames());
		try {
		if(!req.getHeader("x-api-key").equalsIgnoreCase("12345")){
			return new ResponseEntity<>("Please use proper headers",HttpStatus.FORBIDDEN);
		}
		else {
			String response = service.getInfo(request);
			js.put("finalResponse", response);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			js.put("Message",e.getMessage());
			return new ResponseEntity<>("Error in the request or headers",HttpStatus.BAD_GATEWAY);
		}
		
	}
}
