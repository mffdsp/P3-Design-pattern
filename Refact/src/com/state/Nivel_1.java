package com.state;

import com.employee.Funcionario;

public class Nivel_1 implements State{

	public String toString() {
		return "Nivel 1";
	}
	
	public void promote(Funcionario f) {
		
		f.setSalary(f.getSalary()*1.0);
		f.setState( new Nivel_2() );
		
	}

}
