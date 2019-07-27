package com.payroll;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.adm.Command;
import com.adm.Utility;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.view.MainView;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxaS extends JFrame {

	private JPanel contentPane;
	private JTextField TFvalor;

	public TaxaS(Funcionario[] func, int index) {
		Utility UT = new Utility();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 205);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		setTitle("Registrar Taxa");
		
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
