package com.mainApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mainApp.model.Employee;
import com.mainApp.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = empRepo.findById(id);
		return optional.orElseThrow(() -> new EmployeeNotFoundException("No such Employee " + id));
	}

	public Employee updateEmployee(long id, Employee empDetails) {
		Employee employee = empRepo.getOne(id);
		employee.setId(id);
		employee.setName(empDetails.getName());

		return empRepo.save(employee);
	}

	public ResponseEntity<Employee> deleteEmployee(long id) {
		Employee employee = empRepo.getOne(id);
		empRepo.delete(employee);
		return ResponseEntity.ok().build();
	}

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

//	public long countEmployees() {
//		return 0;
//	}

}
