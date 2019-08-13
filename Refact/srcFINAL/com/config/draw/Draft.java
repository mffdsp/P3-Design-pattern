package com.config.draw;

import com.elements.employee.Funcionario;

public abstract class Draft {

	public final void sorteioDiario(Funcionario[] f) {
		selecionarFuncionarios(f);
		sortearFuncionario(); 
		addPremio(f);
	}

	abstract void selecionarFuncionarios(Funcionario[] f);
	abstract void sortearFuncionario();
	abstract void addPremio(Funcionario[] f);

}
