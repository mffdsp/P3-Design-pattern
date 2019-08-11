package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.adm.Utility;
import com.draw.Draw;
import com.draw.Fortune;
import com.employee.Funcionario;

public class DrawView extends JFrame {

	private JPanel contentPane;
	Draw draw = new Fortune();
	Utility UT = new Utility();
	
	public DrawView(Funcionario[] f) throws InterruptedException { 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 224, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Sorteio!");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height; 
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2 - 150, height/2-getSize().height/2);
		
		JButton btnSorteio = new JButton("GO");
		JTextPane txtpnRegrasFuncionario = new JTextPane();
		JProgressBar progressBar = new JProgressBar();
		
		btnSorteio.setBounds(143, 187, 55, 31);
		progressBar.setBounds(30, 162, 146, 14);
		txtpnRegrasFuncionario.setBounds(30, 11, 141, 132);
		txtpnRegrasFuncionario.setText("Regras:\r\n\r\n- Funcionario deve possuir associa\u00E7\u00E3o sindical.\r\n- Bonifica\u00E7\u00E3o ser\u00E1 aplicada no pr\u00F3ximo sal\u00E1rio.\r\n");

		btnSorteio.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				UT.progressBar(progressBar);	
				draw.sorteioDiario(f);	
				setVisible(false);
			}
		});
		
		contentPane.add(progressBar);
		contentPane.add(btnSorteio);
		contentPane.add(txtpnRegrasFuncionario);
		
		
		
				
		
		
		
	}
}
