package com.config.state;

import com.elements.employee.Funcionario;

public class Senior implements State{
	
	public String toString() {
		return "Nivel Senior";
	}
	
	public void promote(Funcionario f) {
		System.out.println("EndOF");
		
	}

}
