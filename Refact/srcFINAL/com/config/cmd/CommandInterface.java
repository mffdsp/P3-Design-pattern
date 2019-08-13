package com.config.cmd;

import com.elements.employee.Funcionario;

public interface CommandInterface {
	
	void Undo();
	void Redo();
	void Action(String action, Funcionario[] funcionarios);
	
}
