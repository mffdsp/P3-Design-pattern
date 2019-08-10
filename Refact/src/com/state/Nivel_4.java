package com.state;

import com.employee.Funcionario;

public class Nivel_4 implements State{

	public String toString() {
		return "Nivel 4";
	}
	
	public void promote(Funcionario f) {
		
		f.setSalary(f.getSalary()*1.3);
		f.setState(new Senior());
		
	}

}
