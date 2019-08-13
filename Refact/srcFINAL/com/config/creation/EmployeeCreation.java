package com.config.creation;

import com.elements.employee.Funcionario;

public interface EmployeeCreation {
	
	 public Funcionario getEmployee(String type, String name, String adress, String ftype, String payMode, String code) throws Exception;
}
