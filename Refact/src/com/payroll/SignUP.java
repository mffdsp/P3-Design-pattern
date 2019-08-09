package com.payroll;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.adm.Utility;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.factoryPattern.FactoryEmployee;
import com.factoryPattern.FactorySchedule;
import com.memento.Cmd;
import com.memento.Memento;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class SignUP extends JFrame {
	
	FactoryEmployee FactoryEmployee = new FactoryEmployee();
	
	private static double DBsalary = -1;
	private static boolean invalidenumber = true;
	private JPanel contentPane;
	private JTextField AdressField;
	private JTextField NameField;
	private JTextField SalaryField;
	private JLabel errotext;
	boolean sind = false;
	Utility UT = new Utility();
	JComboBox CBtype = new JComboBox(); 
	JComboBox CBptype = new JComboBox();  
	
	public void saveValues(Funcionario[] func, int index) throws Exception {
		
		switch(CBtype.getSelectedItem().toString()) { 
			
		case "Assalariado":
			func[index] = FactoryEmployee.getEmployee("A", NameField.getText(), AdressField.getText(), CBtype.getSelectedItem().toString(), CBptype.getSelectedItem().toString(), "2019" + index );
			break;
			
		case "Horista":
			func[index] = FactoryEmployee.getEmployee("H", NameField.getText(), AdressField.getText(), CBtype.getSelectedItem().toString(), CBptype.getSelectedItem().toString(), "2019" + index );
			break; 
			
		case "Comissionado":
			func[index] = FactoryEmployee.getEmployee("C", NameField.getText(), AdressField.getText(), CBtype.getSelectedItem().toString(), CBptype.getSelectedItem().toString(), "2019" + index );
			break;
		}
		
		func[index].union.setSindicaty(sind);
		
		if(sind) {
			int indexs = 0;
			while(indexs < 500) {
				if(UT.isFree(func, "111" + indexs)) {
					func[index].getUnion().setSindicatycode("111" + indexs);
					break;
				}indexs += 1;
			}
		}
		
		
	}
	
	public void POPUP(Funcionario[] func, int index){
		
		FactorySchedule factorySchedule = new FactorySchedule();
		
		try {
			saveValues(func, index);
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		try {
			DBsalary = Double.parseDouble(SalaryField.getText());
			invalidenumber = false;
		}catch(Exception ec) {
			System.err.println(ec);
			invalidenumber = true;
		}
		if(func[index].getName().equals("") || func[index].getAdress().equals("") || invalidenumber || DBsalary == -1) {
			JOptionPane.showMessageDialog(null ,
					"Preencha todos os campos corretamente!", "ERRO", JOptionPane.WARNING_MESSAGE);
			return;
		}
		func[index].setSalary(DBsalary);
		JOptionPane.showMessageDialog(null ,
				"Funcionário adicionado com sucesso!", "Feito", JOptionPane.INFORMATION_MESSAGE);
		
		if(func[index].getType().equals("Horista")) {
			((Horista) func[index]).setSalarioBase(Double.parseDouble(SalaryField.getText()));
			func[index].setSalary(0);
			func[index].setFrequenciaD(7); 
			
			Agenda agenda = factorySchedule.getSchedule("Semanal", "Sexta-Feira", 1);
			func[index].setAgenda(agenda);
			
		}if(func[index].getType().equals("Assalariado")) {
						
			func[index].setFrequenciaD(10);
			
			Agenda agenda = factorySchedule.getSchedule("Mensal", "30", 1);
			func[index].setAgenda(agenda);
			
		}if(func[index].getType().equals("Comissionado")) {
			func[index].setFrequenciaD(6);
			
			Agenda agenda = factorySchedule.getSchedule("Semanal", "Sexta-Feira", 2);
			
			func[index].setAgenda(agenda);
			
			((Comissionado)func[index]).setPVenda(15);
			((Comissionado)func[index]).setPsalary(func[index].getSalary());
		}
		
		func[index].setSalarybup(DBsalary);
		Cmd.URpago[index] = false;
		func[index].setSaved(true);
		try {
			Memento.saveState(func); 
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		return;
						
	}
	
	public SignUP(Funcionario[] func, int index) {
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setForeground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Funcionário ao Sistema");
		setBounds(100, 100, 450, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(576, 540);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JLabel LBname = new JLabel("Nome:");
		LBname.setBounds(28, 128, 56, 21);
		LBname.setForeground(Color.BLACK);
		LBname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel LBadress = new JLabel("Endere\u00E7o:");
		LBadress.setBounds(28, 164, 93, 21);
		LBadress.setForeground(SystemColor.activeCaptionText);
		LBadress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel LBvalue = new JLabel("Valor:");
		LBvalue.setBounds(28, 418, 71, 21);
		LBvalue.setForeground(Color.BLACK);
		LBvalue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		AdressField = new JTextField();
		AdressField.setBounds(142, 161, 285, 24);
		AdressField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
	                
	            }
	        }
		});
		AdressField.setBackground(SystemColor.textHighlightText);
		AdressField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setBounds(142, 126, 285, 24);
		NameField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
		               
	            }
	        }
		});
		NameField.setBackground(SystemColor.textHighlightText);
		NameField.setForeground(SystemColor.desktop);
		NameField.setColumns(10);
		
		SalaryField = new JTextField();
		SalaryField.setHorizontalAlignment(SwingConstants.RIGHT);
		SalaryField.setBounds(77, 419, 57, 24);
		SalaryField.setBackground(SystemColor.textHighlightText);
		SalaryField.setColumns(10);
		SalaryField.setText("");
		errotext = new JLabel("");
		errotext.setBounds(272, 426, 0, 0);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(457, 337, 93, 158);
		 
		SalaryField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
	               
	            }
	        }
		});

		btnSalvar.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				POPUP(func, index);
			}
		});
		
		
		JLabel LBrs = new JLabel("R$");
		LBrs.setHorizontalAlignment(SwingConstants.LEFT);
		LBrs.setForeground(Color.BLACK);
		LBrs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBrs.setBounds(136, 420, 71, 21);
	
		JLabel LBtype = new JLabel("Tipo de funcin\u00E1rio:");
		LBtype.setBounds(28, 196, 202, 21);
		LBtype.setForeground(Color.BLACK);
		LBtype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		CBtype.setBounds(287, 199, 140, 20);
		CBtype.setModel(new DefaultComboBoxModel(new String[] {"Horista", "Assalariado", "Comissionado"}));
		CBtype.setSelectedIndex(1);
		CBtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CBtype.getSelectedItem().toString().equals(("Horista"))) { 
					LBrs.setText("R$/hora");
				}else LBrs.setText("R$");
			}
		});
		
		JLabel LBpayt = new JLabel("M\u00E9todo de pagamento:");
		LBpayt.setBounds(28, 386, 202, 21);
		LBpayt.setForeground(Color.BLACK);
		LBpayt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		CBptype.setBounds(223, 386, 140, 20);
		CBptype.setModel(new DefaultComboBoxModel(new String[] {"Correios", "Maos", "Conta bancaria"}));
		 
		JLabel lbimg = new JLabel("");
		lbimg.setBounds(28, 11, 145, 107);
		lbimg.setIcon(new ImageIcon(SignUP.class.getResource("/com/payroll/icons/icons8-gest\u00E3o-de-cliente-100.png")));
	
		
		JLabel LBcoinic = new JLabel("");
		LBcoinic.setIcon(new ImageIcon(SignUP.class.getResource("/com/payroll/icons/icons8-caro-64.png")));
		LBcoinic.setBounds(28, 279, 106, 107);
		
		
		JLabel LBsindboo = new JLabel("Associa\u00E7\u00E3o Sindical:");
		LBsindboo.setForeground(Color.BLACK);
		LBsindboo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBsindboo.setBounds(28, 228, 202, 21);
		
		
		JComboBox CBsindboo = new JComboBox();
		
		CBsindboo.setModel(new DefaultComboBoxModel(new String[] {"N\u00C3O", "SIM"}));
		CBsindboo.setBounds(287, 231, 140, 20);
	
		
		JLabel codeLabel = new JLabel("New label");
		codeLabel.setForeground(SystemColor.textHighlight);
		codeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		codeLabel.setBounds(507, 11, 67, 14);
		
		
		codeLabel.setText("2019" + index); 
		
		JLabel ScodeLabel = new JLabel("Código Sindical: ");
		ScodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ScodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ScodeLabel.setBounds(268, 249, 159, 33);
		ScodeLabel.setVisible(false);
		
		contentPane.add(LBrs);
		contentPane.setLayout(null);
		contentPane.add(btnSalvar);
		contentPane.add(LBadress);
		contentPane.add(LBname);
		contentPane.add(LBvalue);
		contentPane.add(SalaryField);
		contentPane.add(AdressField);
		contentPane.add(NameField);
		contentPane.add(errotext);
		contentPane.add(lbimg);
		contentPane.add(LBpayt);
		contentPane.add(CBptype);
		contentPane.add(LBtype);
		contentPane.add(CBtype);
		contentPane.add(LBcoinic);
		contentPane.add(LBsindboo);
		contentPane.add(CBsindboo);
		contentPane.add(codeLabel);
		contentPane.add(ScodeLabel);

		CBsindboo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(CBsindboo.getSelectedItem().equals("SIM")) {
					ScodeLabel.setVisible(true);
					sind = true;
					int indexs = 0;
					while(indexs < 500) {
						if(UT.isFree(func, "111" + indexs)) {
							ScodeLabel.setText("Código sindical: " + "111" + indexs);
							break;
						} indexs += 1;
					}
					
				}else {
					sind = false;
					ScodeLabel.setText("");
				}
			}
		});
		
		}
}
