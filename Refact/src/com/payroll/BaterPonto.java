package com.payroll;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.builder.BaterPontoBuilder;
import com.employee.Funcionario;

public class BaterPonto extends JFrame {

		
	public BaterPonto(Funcionario[] func, int index) {
		 
		BaterPontoBuilder baterPontoBuilder = new BaterPontoBuilder(); 
		baterPontoBuilder.config(this);
		
		JPanel contentPane = new JPanel(); 
		baterPontoBuilder.config(contentPane);
		setContentPane(contentPane); 
		
		JLabel lb1 = new JLabel("Bem vindo, " + func[index].getName());
		JLabel lb2 = new JLabel("Selecione uma opção:");
		JButton btnENTRADA = new JButton("Registrar Entrada");
		JButton btnSAIDA = new JButton("Registrar Saída");
		
		baterPontoBuilder.addLBL(contentPane, lb1, lb2);
		baterPontoBuilder.addBTN(contentPane, btnENTRADA, btnSAIDA, func, index, this);
	
	}
}
