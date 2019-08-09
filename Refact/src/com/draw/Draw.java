package com.draw;

import com.employee.Funcionario;

public abstract class Draw {

	public final void sorteioDiario(Funcionario[] f) {
		selecionarFuncionarios(f);
		sortearFuncionario(); 
		addPremio(f);
	}

	abstract void selecionarFuncionarios(Funcionario[] f);
	abstract void sortearFuncionario();
	abstract void addPremio(Funcionario[] f);

}
