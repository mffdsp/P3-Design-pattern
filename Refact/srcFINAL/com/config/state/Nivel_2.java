package com.config.state;

import com.elements.employee.Funcionario;

public class Nivel_2 implements State{
	
	public String toString() {
		return "Nivel 2";
	}
	
	public void promote(Funcionario f) {
		
		f.setSalary(f.getSalary()*1.1);
		f.setState( new Nivel_3() );
		
	}

}
