package com.mainApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mainApp.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	Employee updateEmployee(long id, Employee employee);
	ResponseEntity<Employee> deleteEmployee(long id);
	List<Employee> getAllEmployees();
//	long countEmployees();
}
