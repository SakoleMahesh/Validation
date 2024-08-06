package com.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.entity.Employee;
import com.validation.service.EmployeeServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	
	
	{
		
		Employee employeeById = employeeServiceInterface.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee,BindingResult result)
	{
		Employee employee2 = employeeServiceInterface.createEmployee(employee);
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id)
	{
		 employeeServiceInterface.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		Employee employee2 = employeeServiceInterface.updateEmployee(id,employee);
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updatePatchEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		Employee employee2 = employeeServiceInterface.updatePatchEmployee(id,employee);
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
}
