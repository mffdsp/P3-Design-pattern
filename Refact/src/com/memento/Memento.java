package com.memento;

import com.employee.Funcionario;

public class Memento {

	public static void saveState(Funcionario[] funcionarios) throws CloneNotSupportedException {
		try {
			Cmd.saveS(funcionarios);
		} catch(Exception e) {
			System.err.println(e);
		}
		
	}
	
}
