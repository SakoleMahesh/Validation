package com.validation.service;

import com.validation.entity.Employee;

public interface EmployeeServiceInterface {

 Employee getEmployeeById(Long id);

Employee createEmployee(Employee employee);

void deleteEmployeeById(Long id);
Employee updateEmployee(Long id, Employee employee);

Employee updatePatchEmployee(Long id, Employee employee);

}
