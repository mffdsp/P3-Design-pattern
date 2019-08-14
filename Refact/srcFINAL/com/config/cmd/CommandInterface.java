package com.config.cmd;

import com.elements.employee.Funcionario;

public interface CommandInterface {
	
	void Action(String action, Funcionario[] funcionarios);
	
}
