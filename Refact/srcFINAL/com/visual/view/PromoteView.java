package com.visual.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.config.adm.Utility;
import com.elements.employee.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PromoteView extends JFrame  {

	private JPanel contentPane;
	Utility UT = new Utility();
	
	public PromoteView(Funcionario[] f) throws CloneNotSupportedException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 161);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		setTitle("Promover Funcionário");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height; 
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JTextField codeField = new JTextField();
		codeField.setBounds(59, 38, 96, 25);
		contentPane.add(codeField);
		codeField.setColumns(10);
		
		JButton btnNewButton = new JButton("Promover");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int indice = 0;
				boolean notvalid = true;
				try {
					
					indice = UT.getIndex(codeField.getText());
					notvalid = f[indice] == null || Integer.parseInt(codeField.getText()) < 20190 || !f[indice].isSaved();
					if(notvalid) {
						JOptionPane.showMessageDialog(null ,
								"Funcionário não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
						return;
					}else {
						
						f[indice].promote();
						
						JOptionPane.showMessageDialog(null ,
								f[indice].getName() + ",\nPromovido ao cargo de " + f[indice].getState() + "!\nBonus associado ao salário!", "Sucesso!", JOptionPane.DEFAULT_OPTION);
						return;
					}
				}
				catch(Exception e0) {
					System.err.println(e0);
					JOptionPane.showMessageDialog(null ,
							"Formato inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		btnNewButton.setBounds(48, 69, 118, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblInsiraOCdigo = new JLabel("Insira o C\u00F3digo:");
		lblInsiraOCdigo.setBounds(59, 13, 96, 14);
		contentPane.add(lblInsiraOCdigo);
		
		
		
	}
}
