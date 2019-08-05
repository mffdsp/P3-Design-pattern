package com.factoryPattern;

import com.employee.Funcionario;

public interface EmployeeCreation {
	
	 public Funcionario getEmployee(String type, String name, String adress, String ftype, String payMode, String code) throws Exception;
}
