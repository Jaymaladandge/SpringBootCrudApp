package com.mainApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainApp.model.Employee;
import com.mainApp.service.EmployeeService;

@RestController
@RequestMapping("/app")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/emp")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/emp/{id}")
	public Employee getEmpById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/emp/{id}")
	public Employee updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/emp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}

}
