package com.payroll;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.adm.CalendarMT;
import com.adm.Command;
import com.employee.Funcionario;
import com.employee.Horista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaterPonto extends JFrame {

	private JPanel contentPane;
		
	public BaterPonto(Funcionario[] func, int index) {
		 
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 263, 208);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		setTitle("Lançar Cartão de Ponto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb1 = new JLabel("Bem vindo, " + func[index].getName());
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setBounds(10, 11, 156, 22);
		contentPane.add(lb1);
	
		JButton btnENTRADA = new JButton("Registrar Entrada");
		btnENTRADA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!func[index].isCheckIN()) {
				func[index].setCheckIN(true);
				JOptionPane.showMessageDialog(null ,
						"Entrada registrada com sucesso! as " + CalendarMT.Ahora + ":"+  CalendarMT.Aminuto, "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
				func[index].setTimeIN(CalendarMT.Ahora);
				try {
					Command.saveS(func);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null ,"Entrada Já registrada hoje", "ERRO!", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnENTRADA.setBounds(0, 75, 247, 48);
		contentPane.add(btnENTRADA);
		
		JButton btnSAIDA = new JButton("Registrar Saída");
		btnSAIDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Se ainda nao bateu a entrada
				if(!func[index].isCheckIN()){
					JOptionPane.showMessageDialog(null ,"Ponto de entrada ainda não registrado", "Ação Inválida", 
							JOptionPane.ERROR_MESSAGE); 
				
				//Se já bateu entrada e saida
				}else if(func[index].isCheckIN() && func[index].isCheckOUT()){
					JOptionPane.showMessageDialog(null ,"Cartão de Hoje já foi batido com sucesso", "Ação Inválida", 
					JOptionPane.ERROR_MESSAGE);
				
				//Sucesso
				}else { 
					func[index].setCheckOUT(true);
					func[index].setTimeOUT(CalendarMT.Ahora);
					int value = func[index].getTimeOUT() - func[index].getTimeIN();
					
					JOptionPane.showMessageDialog(null ,
							"Saída registrada com sucesso! as " + CalendarMT.Ahora  + ":" + CalendarMT.Aminuto + 
							"\nHoras trabalhadas hoje: " + value + "Hrs", "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
					
					//Caso horista, gera o "adicional", metodo add();
					if(func[index] instanceof Horista) {
						((Horista) func[index]).addSalary(value);
						((Horista) func[index]).setPsalary(func[index].getSalary());
						JOptionPane.showMessageDialog(null ,
								"Funcionário do tipo horista!" +
								""
								+ "\nSalario acumulado:" + func[index].getSalary() + "R$", "Horista", 	JOptionPane.INFORMATION_MESSAGE);
					}
					
					try {
						Command.saveS(func);
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setVisible(false);
				}
				
			}
		});
		btnSAIDA.setBounds(0, 122, 247, 48);
		contentPane.add(btnSAIDA);
		
		JLabel lb2 = new JLabel("Selecione uma opção:");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setBounds(10, 34, 156, 30);
		contentPane.add(lb2);
	}
}
