package com.memento;

import com.employee.Funcionario;

public interface CommandInterface {
	
	void Undo();
	void Redo();
	void Action(String action, Funcionario[] funcionarios);
	
}
