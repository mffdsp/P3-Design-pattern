package com.config.draw;

import java.util.Random;

import javax.swing.JOptionPane;

import com.elements.employee.Funcionario;

public class Fortune extends Draft {

	int[] fortuneList = new int[500];
	double prize = 500;
	int ganhador = -1;
	boolean validFortune = false;

	void selecionarFuncionarios(Funcionario[] f) {

		for(int i = 0; i < 500; i++) {
			if(isValid(f[i])) {
				fortuneList[i] = 1;
				validFortune = true;
			}
		}

	}

	void sortearFuncionario() {

		while(validFortune) {

			int number = new Random().nextInt(500);
			if(fortuneList[number] == 1) {
				ganhador = number;
				return;
			}
		}

		JOptionPane.showMessageDialog(null ,
				"Não há funcionários mínimos para concorrer!", "Sucesso!", JOptionPane.ERROR_MESSAGE);

	}

	void addPremio(Funcionario[] f) {

		if(!validFortune) {
			return;
		}

		f[this.ganhador].setSalary(f[this.ganhador].getSalary() + prize);

		JOptionPane.showMessageDialog(null ,
				"Funcionário ganhador possui ID: "
						+ f[this.ganhador].getCode() + "\nID de sindicato: " + f[this.ganhador].getUnion().getSindicatycode() 
						+ "\nValor adicionado: " +
						prize + "RS", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	private boolean isValid(Funcionario f) {
		return f.isSaved() && f.getUnion().isSindicaty();
	}



}
