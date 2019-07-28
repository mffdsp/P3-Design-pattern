package com.buttons;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.employee.Funcionario;

public interface ButtonInterface {
	
	void addBT(JButton BT, JPanel cp);
	void styleBT(JButton BT, JPanel cp);
	void handlerBT(JButton BT, Funcionario[] funcionarios);
}
