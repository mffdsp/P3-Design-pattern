package com.buttons.main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.employee.Funcionario;
import com.handler.Handler;

public class CommandPattern {

	public void addAction(ActionEvent e, Funcionario[] funcionarios) {
		Handler Handler = new Handler();
		try {
			Handler.addViewHandler(funcionarios);
		} catch (Exception ex) {
			ex.printStackTrace();
		}   
		
	}
}
