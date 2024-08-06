package com.validation.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.entity.Employee;
import com.validation.exception.EmployeeNotFoundException;
import com.validation.repository.EmployeeRepository;
import com.validation.service.EmployeeServiceInterface;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee","Emplyee Id:",id));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employee2 = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee","Emplyee Id:",id));
		// TODO Auto-generated method stub
		employee2.setId(employee.getId());
		employee2.setName(employee.getName());
		employee2.setEmail(employee.getEmail());
		employee2.setPassword(employee.getPassword());
		return employeeRepository.save(employee2);
	}

	@Override
	public Employee updatePatchEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2 = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee","Emplyee Id:",id));
		employee2.setName(employee.getName());
		employee2.setEmail(employee.getEmail());
		return employeeRepository.save(employee);
	}

}
