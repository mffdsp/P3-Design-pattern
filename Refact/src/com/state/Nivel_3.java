package com.state;

import com.employee.Funcionario;

public class Nivel_3 implements State{

	public String toString() {
		return "Nivel 3";
	}
	
	public void promote(Funcionario f) {
		
		f.setSalary(f.getSalary()*1.2);
		f.setState( new Nivel_4() );
		
	}

}
