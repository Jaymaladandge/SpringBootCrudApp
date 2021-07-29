package com.mainApp.service;

import javax.persistence.PersistenceException;

public class EmployeeNotFoundException extends PersistenceException{

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
