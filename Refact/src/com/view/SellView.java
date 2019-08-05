package com.view;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.builder.SellViewBuilder;
import com.employee.Funcionario;

public class SellView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	
	public SellView(Funcionario[] func, int index) {
		
		SellViewBuilder SellViewBuilder = new SellViewBuilder();
		
		SellViewBuilder.config(this, contentPane);
		SellViewBuilder.config(contentPane);
		
		JButton BTsave = new JButton("Save");
		JEditorPane TFobs = new JEditorPane();
		JTextField TFvalor = new JTextField(); 
		JLabel LBtaxa = new JLabel("Valor da Venda:");  
		
		SellViewBuilder.addBTN(contentPane, BTsave, TFobs, TFvalor, func, index, this);
		SellViewBuilder.addLBL(contentPane, LBtaxa);
		 
	}

}
