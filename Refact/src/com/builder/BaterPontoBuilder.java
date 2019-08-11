package com.builder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.adm.CalendarMT;
import com.cmd.Cmd;
import com.cmd.Singleton;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.BaterPonto;

public class BaterPontoBuilder {
	
	public void config(BaterPonto frame) {
        
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 263, 208);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		frame.setTitle("Lançar Cartão de Ponto"); 
        
    } 

    public void config(JPanel contentPane) {

    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
    }
    
    public void addLBL(JPanel contentPane, JLabel lb1, JLabel lb2) {
    	
    	lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setBounds(10, 11, 156, 22); 
		
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setBounds(10, 34, 156, 30);
		
		contentPane.add(lb1);
		contentPane.add(lb2);
		
    }
    public void addBTN(JPanel contentPane, JButton btnENTRADA, JButton btnSAIDA, Funcionario[] func, int index, BaterPonto frame) {
    	
    	btnENTRADA.setBounds(0, 75, 247, 48);
		btnSAIDA.setBounds(0, 122, 247, 48);
		
		btnSAIDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!func[index].getTimeCard().isCheckIN()){
					JOptionPane.showMessageDialog(null ,"Ponto de entrada ainda não registrado", "Ação Inválida", 
							JOptionPane.ERROR_MESSAGE); 
				
				}else if(func[index].getTimeCard().isCheckIN() && func[index].timecard.isCheckOUT()){
					JOptionPane.showMessageDialog(null ,"Cartão de Hoje já foi batido com sucesso", "Ação Inválida", 
					JOptionPane.ERROR_MESSAGE);
				
				}else { 
					func[index].getTimeCard().setCheckOUT(true);
					func[index].getTimeCard().setTimeOUT(CalendarMT.Ahora);
					int value = func[index].getTimeCard().getTimeOUT() - func[index].getTimeCard().getTimeIN();
					
					JOptionPane.showMessageDialog(null ,
							"Saída registrada com sucesso! as " + CalendarMT.Ahora  + ":" + CalendarMT.Aminuto + 
							"\nHoras trabalhadas hoje: " + value + "Hrs", "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
					
					if(func[index].getType().equals("Horista")) {
						
						((Horista) func[index]).addSalary(value);
						((Horista) func[index]).setPsalary(func[index].getSalary());
						JOptionPane.showMessageDialog(null ,
								"Funcionário do tipo horista!" +
								""
								+ "\nSalario acumulado:" + func[index].getSalary() + "R$", "Horista", 	JOptionPane.INFORMATION_MESSAGE);
					}
					
					try {
						Cmd cmdSingleton = Singleton.getInstance();		
						cmdSingleton.saveS(func); 
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
					frame.setVisible(false);
				}
				
			}
		});
		
		btnENTRADA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!func[index].getTimeCard().isCheckIN()) {
					
				func[index].getTimeCard().setCheckIN(true);
				JOptionPane.showMessageDialog(null ,
						"Entrada registrada com sucesso! as " + CalendarMT.Ahora + ":"+  CalendarMT.Aminuto, "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
				func[index].getTimeCard().setTimeIN(CalendarMT.Ahora);
				
				try {
					Cmd cmdSingleton = Singleton.getInstance();		
					cmdSingleton.saveS(func);
					
				} catch (CloneNotSupportedException e) {
					
					e.printStackTrace();
				}
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null ,"Entrada Já registrada hoje", "ERRO!", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		contentPane.add(btnSAIDA);
		contentPane.add(btnENTRADA);
    	
    }

}
