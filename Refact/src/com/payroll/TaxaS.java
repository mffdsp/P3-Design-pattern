package com.payroll;


import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.adm.Command;
import com.adm.Utility;
import com.builder.TaxaViewBuilder;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;

public class TaxaS extends JFrame {

	private JTextField TFvalor;

	public TaxaS(Funcionario[] func, int index) {
		
		Utility UT = new Utility();
		
		TaxaViewBuilder TaxaViewBuilder = new TaxaViewBuilder();
		
		TaxaViewBuilder.config(this);
		
		JPanel contentPane = new JPanel();
		TaxaViewBuilder.config(contentPane);
		setContentPane(contentPane);
		
		
		JEditorPane TFobs = new JEditorPane();
		TFobs.setBackground(SystemColor.textHighlightText);
		TFobs.setText("Insira as observa\u00E7\u00F5es sobre a Taxa");
		TFobs.setBounds(0, 87, 141, 79);
		contentPane.add(TFobs);
		
		TFvalor = new JTextField();
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(113, 24, 86, 29);
		contentPane.add(TFvalor);
		TFvalor.setColumns(10);
		 
		JLabel LBtaxa = new JLabel("Valor de Taxa:");
		LBtaxa.setHorizontalAlignment(SwingConstants.LEFT);
		LBtaxa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LBtaxa.setBounds(10, 31, 93, 14);
		contentPane.add(LBtaxa); 
		
		JButton BTsave = new JButton("Save");
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					double value = Double.parseDouble(TFvalor.getText());
					double salary = func[index].getSalary();
					
					if(func[index] instanceof Comissionado) {
						
						salary = func[index].getSalary() + ((Comissionado)func[index]).getBonussalary();
						((Comissionado)func[index]).setPsalary( salary - value);
						
					}else {
						func[index].setSalary(salary - value);
						if(func[index] instanceof Horista) {
							((Horista)func[index]).setPsalary(func[index].getSalary());
						}
						if(func[index] instanceof Assalariado) {
							((Assalariado)func[index]).setPsalary(func[index].getSalary());
						}
					}
					
					JOptionPane.showMessageDialog(null ,
							"Taxa debitada com sucesso à: \n"
							+ func[index].getName() + "\nCódigo Sindical: " + func[index].getSindicatycode(), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					Command.saveS(func);
					setVisible(false);
							
				} catch(Exception ex0) {
					UT.ERRO();
					System.err.println(ex0); 
					return;
				}
			}
		});
		BTsave.setBounds(140, 87, 69, 79);
		contentPane.add(BTsave);
		
	}
}
