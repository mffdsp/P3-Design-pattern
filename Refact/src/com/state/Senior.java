package com.state;

import com.employee.Funcionario;

public class Senior implements State{
	
	public String toString() {
		return "Nivel Senior";
	}
	
	public void promote(Funcionario f) {
		System.out.println("EndOF");
		
	}

}
