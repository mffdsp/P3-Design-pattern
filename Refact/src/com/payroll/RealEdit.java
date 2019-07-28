package com.payroll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.adm.Command;
import com.adm.Utility;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.factory.FactoryEmployee;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;
import com.view.MainView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;

public class RealEdit extends JFrame {

	private JPanel contentPane;
	private JTextField TFvalor;
	private JTextField TFadress;
	private JTextField TFname;
	private int acc = 1;
	boolean custom = false;
	private JTextField TFcomi;
	private JTextField TFscode; 

	public RealEdit(Funcionario[] func, int index, Agenda[] agenda) {
		
		custom = func[index].isCustom();

		Utility UT = new Utility();
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblEditar = new JLabel("EDITAR");
		contentPane.add(lblEditar, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setFocusCycleRoot(true);
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 604, 506);
		contentPane.add(panel);
		
		JButton BTsave = new JButton("Salvar");
		BTsave.setBounds(501, 337, 93, 158);
		panel.add(BTsave);
		
		JLabel LBadress = new JLabel("Endere\u00E7o:");
		LBadress.setForeground(Color.BLACK);
		LBadress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBadress.setBounds(28, 164, 93, 21);
		panel.add(LBadress);
		
		JLabel LBname = new JLabel("Nome:");
		LBname.setForeground(Color.BLACK);
		LBname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBname.setBounds(28, 128, 56, 21);
		panel.add(LBname);
		
		JLabel LBvalor = new JLabel("Valor:");
		LBvalor.setForeground(Color.BLACK);
		LBvalor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBvalor.setBounds(26, 386, 71, 21);
		panel.add(LBvalor);
		
		TFvalor = new JTextField();
		TFvalor.setHorizontalAlignment(SwingConstants.RIGHT);
		TFvalor.setColumns(10);
		if(func[index] instanceof Horista)
		{
			TFvalor.setText(Double.toString(((Horista)func[index]).getSalarioBase()));
		}else TFvalor.setText(Double.toString(func[index].getSalary()));	
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(77, 384, 57, 24);
		panel.add(TFvalor);
		
		TFadress = new JTextField();
		TFadress.setText(func[index].getAdress());
		TFadress.setColumns(10);
		TFadress.setBackground(SystemColor.textHighlightText);
		TFadress.setBounds(142, 161, 285, 24);
		panel.add(TFadress);
		
		TFname = new JTextField();
		TFname.setText(func[index].getName());
		TFname.setForeground(Color.BLACK);
		TFname.setColumns(10);
		TFname.setBackground(SystemColor.textHighlightText);
		TFname.setBounds(142, 126, 285, 24);
		panel.add(TFname);

		JLabel LBicon1 = new JLabel("");
		LBicon1.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-gest\u00E3o-de-cliente-100.png")));
		LBicon1.setBounds(28, 11, 145, 107);
		panel.add(LBicon1);
		
		JLabel LBmetodo = new JLabel("M\u00E9todo de pagamento:");
		LBmetodo.setForeground(Color.BLACK);
		LBmetodo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBmetodo.setBounds(28, 352, 202, 21);
		panel.add(LBmetodo);
		
		JComboBox CBmetodo = new JComboBox();
		CBmetodo.setModel(new DefaultComboBoxModel(new String[] { func[index].getPayMode(), "Maos", "Deposito"}));
		CBmetodo.setBounds(224, 355, 140, 20);
		panel.add(CBmetodo);
		
		JLabel LBtipo = new JLabel("Tipo de funcin\u00E1rio:");
		LBtipo.setForeground(Color.BLACK);
		LBtipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBtipo.setBounds(28, 196, 202, 21);
		panel.add(LBtipo);
		
		JLabel LBcomi = new JLabel("Comiss\u00E3o de venda :");
		LBcomi.setForeground(Color.BLACK);
		LBcomi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBcomi.setBounds(26, 418, 164, 21);
		panel.add(LBcomi);
		
		JLabel LBpcomi = new JLabel("%");
		LBpcomi.setForeground(Color.BLACK);
		LBpcomi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBpcomi.setBounds(260, 417, 71, 21);
		panel.add(LBpcomi);
		
		TFcomi = new JTextField();
		TFcomi.setHorizontalAlignment(SwingConstants.RIGHT);
		TFcomi.setColumns(10);
		TFcomi.setBackground(SystemColor.textHighlightText);
		TFcomi.setBounds(200, 416, 57, 24);
		panel.add(TFcomi);
		
		JLabel LBrs = new JLabel("R$");
		LBrs.setHorizontalAlignment(SwingConstants.LEFT);
		LBrs.setForeground(Color.BLACK);
		LBrs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBrs.setBounds(137, 386, 71, 21);
		panel.add(LBrs);
		
		
		JComboBox CBtipo = new JComboBox();
		CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
		
		String setValue = func[index].getType();

		switch(setValue) {
		case "Horista":
			TFcomi.setText("15");
			LBrs.setText("R$/hora");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
			break;
		case "Comissionado":
			LBrs.setText("R$");
			TFcomi.setText(Integer.toString(((Comissionado) func[index]).getPVenda()));
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horista", "Assalariado"}));
			break;
		case "Assalariado":
			TFcomi.setText("15");
			LBrs.setText("R$");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horista", "Comissionado"}));
			break;
		}
		CBtipo.setBounds(287, 196, 140, 20);
		panel.add(CBtipo);
		
		JLabel LBicon2 = new JLabel("");
		LBicon2.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-caro-64.png")));
		LBicon2.setBounds(28, 247, 106, 107);
		panel.add(LBicon2);
		
		
		TFscode = new JTextField();
		TFscode.setHorizontalAlignment(SwingConstants.RIGHT);
		TFscode.setColumns(10);
		TFscode.setBackground(Color.WHITE);
		TFscode.setBounds(369, 67, 57, 24);
		panel.add(TFscode);
		
		JLabel LBscode = new JLabel("S. Code:");
		LBscode.setForeground(Color.BLACK);
		LBscode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBscode.setBounds(260, 66, 92, 21);
		panel.add(LBscode);
		
		JLabel LBindisponivel = new JLabel("indisponivel");
		LBindisponivel.setForeground(Color.RED);
		LBindisponivel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBindisponivel.setBounds(362, 94, 87, 21);
		panel.add(LBindisponivel);
		
		JComboBox CBsind = new JComboBox();
		
		if(func[index].isSindicaty()) {
			CBsind.setModel(new DefaultComboBoxModel(new String[] {"SIM", "NAO"}));
			LBindisponivel.setVisible(false);
			TFscode.setText(func[index].getSindicatycode());
		}else {
			CBsind.setModel(new DefaultComboBoxModel(new String[] {"NAO", "SIM"}));
			LBindisponivel.setVisible(false);
			LBscode.setVisible(false);
			TFscode.setVisible(false);
		}
		CBsind.setBounds(362, 35, 65, 20);
		panel.add(CBsind);
		
		
		CBsind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CBsind.getSelectedItem().toString().equals("SIM")) {
					LBscode.setVisible(true);
					TFscode.setVisible(true);
				}else {
					LBscode.setVisible(false);
					TFscode.setVisible(false);
					
				}
			}
		});
		
		
		JList list = new JList();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		if(func[index].isCustom())
		{
			acc = 0; list.setVisible(true);			
			DefaultListModel DLMA = new DefaultListModel();
			for(int i = 0; i < 50; i++) { 
				if(agenda[i].isSaved()) {
					
					DLMA.addElement(agenda[i]);
				}
			}
			scrollPane_1.setBounds(448, 130, 132, 176);
			list.setForeground(Color.BLACK);
			list.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list.setBorder(new CompoundBorder());
			list.setBackground(Color.WHITE);
			list.setBounds(448, 130, 132, 176);
			panel.add(list); 
			panel.add(scrollPane_1);
			list.setModel(DLMA);
			list.setSelectedIndex(func[index].getAgendaID());
			func[index].setCustom(true);
			scrollPane_1.setViewportView(list);
		}
		
		JButton TFcustom = new JButton("Custom Schedule");
		TFcustom.setToolTipText("Clique para mostrar as agendas");
		TFcustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acc == 1 && agenda[0].isSaved()) 
				{
					acc = 0; list.setVisible(true);			
					DefaultListModel DLMA = new DefaultListModel();
					for(int i = 0; i < 50; i++) { 
						if(agenda[i].isSaved()) {		
							DLMA.addElement(agenda[i]);
						}
					}
					scrollPane_1.setBounds(448, 130, 132, 176);
					list.setForeground(Color.BLACK);
					list.setFont(new Font("Tahoma", Font.PLAIN, 14));
					list.setBorder(new CompoundBorder());
					list.setBackground(Color.WHITE);
					list.setBounds(448, 130, 132, 176);
					panel.add(list); 
					panel.add(scrollPane_1);
					list.setModel(DLMA);
					list.setSelectedIndex(0);
					scrollPane_1.setViewportView(list);
					list.setVisible(true);
					scrollPane_1.setVisible(true);
					custom = true;
				}
				else if(acc == 0) {
					acc = 1;
					custom = false;
					list.setVisible(false);
					scrollPane_1.setVisible(false);
					panel.remove(list);
					
				}
				if(!agenda[0].isSaved()) {
					JOptionPane.showMessageDialog(null ,
							"Ainda não há agendas criadas!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		TFcustom.setBounds(449, 94, 132, 23);
		panel.add(TFcustom);
		
		JLabel LBsind = new JLabel("Sindicato:");
		LBsind.setForeground(Color.BLACK);
		LBsind.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBsind.setBounds(260, 34, 92, 21);
		panel.add(LBsind);
		
	
		CBtipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CBtipo.getSelectedItem().toString().equals("Comissionado")){
					LBcomi.setVisible(true);
					LBpcomi.setVisible(true);
					TFcomi.setVisible(true);
				}else {
					LBcomi.setVisible(false);
					LBpcomi.setVisible(false);
					TFcomi.setVisible(false);
				}
				if(CBtipo.getSelectedItem().toString().equals("Horista")){
					LBrs.setText("R$/hora");
				}else {
					LBrs.setText("R$");
				}
			}
		});
		
		
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FactoryEmployee FactoryEmployee = new FactoryEmployee();
				
				//Salvo valores anteriores a mudança
				int savefrequency = func[index].getFrequenciaD();
				double bonus = 0;
				double savesalary = 0;
				
				if(func[index] instanceof Comissionado) {
					bonus = ((Comissionado)func[index]).getBonussalary();
				}
				if(func[index] instanceof Horista) {
					savesalary = ((Horista)func[index]).getSalary();
				}

				
				//BEGINOFTRY CATCH, BEFORE SAVING
				if(!UT.isFree(func, TFscode.getText()) && TFscode.isVisible() && !TFscode.getText().equals(func[index].getSindicatycode())) {
					LBindisponivel.setVisible(true);
					UT.ERRO();
					return;
				}
				try {
					if(TFscode.isVisible()) {
						Double.parseDouble(TFscode.getText());
					}
					if(TFvalor.isVisible()) {
						Double.parseDouble(TFvalor.getText());
					}
				
				}catch(Exception ex1) {
					System.err.println(ex1);
					UT.ERRO();
					return;
				}
				try {
					if(Integer.parseInt(TFcomi.getText()) > 100 || Integer.parseInt(TFcomi.getText()) < 0) {
						throw new Exception("Valores fora do intervalo <insira entre 0 e 100>");
					}
				}catch(Exception ex3) {
					System.err.println(ex3);
					UT.ERRO();
					return;
				}
				//ENDOFTRY CATCH, BEFORE SAVING
				//Se não há erro, peço confirmação

				Agenda nocustom = new Agenda(); 
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja salvar as informações?", "Confirmação", dialogButton);
				if(!(dialogResult == JOptionPane.YES_OPTION) ){
					return;
				}
				String SVname = TFname.getText();
				String SVadress = TFadress.getText();
				String SVmetodo = CBmetodo.getSelectedItem().toString();
				String SVcode = "2019" + index;
				
				if(CBtipo.getSelectedItem().toString().equals("Assalariado") && !custom) {
					
					func[index] = FactoryEmployee.getEmployee("A", SVname, SVadress, "Assalariado", SVmetodo , SVcode);
					func[index].setType("Assalariado");

					nocustom = new Mensal();
					((Mensal)nocustom).setDia(30);
					nocustom.setFrequencia(1);
					func[index].setAgenda(nocustom);
					
				}else if(CBtipo.getSelectedItem().toString().equals("Horista")  && !custom) {
					
					func[index] = FactoryEmployee.getEmployee("H", SVname, SVadress, "Horista", SVmetodo , SVcode);
					func[index].setType("Horista");
					
					nocustom = new Semanal();
					((Semanal)nocustom).setDia("Sexta-Feira");
					nocustom.setFrequencia(1);
					func[index].setAgenda(nocustom);
					
				}else if(CBtipo.getSelectedItem().toString().equals("Comissionado") && !custom ) {
					
					func[index] = FactoryEmployee.getEmployee("C", SVname, SVadress, "Comissionado", SVmetodo , SVcode);
					func[index].setType("Comissionado");
					
					nocustom = new Semanal();

					((Semanal)nocustom).setDia("Sexta-Feira");
					nocustom.setFrequencia(2);
					func[index].setAgenda(nocustom);
					
				}else if(custom && list.getSelectedIndex() >= 0) { //Tratando das agendas personalizadas
					
					if(CBtipo.getSelectedItem().toString().equals("Comissionado")) {
						func[index] = FactoryEmployee.getEmployee("C", SVname, SVadress, "Comissionado", SVmetodo , SVcode);

					}if(CBtipo.getSelectedItem().toString().equals("Horista")) {
						func[index] = FactoryEmployee.getEmployee("H", SVname, SVadress, "Horista", SVmetodo , SVcode);
						
					}if(CBtipo.getSelectedItem().toString().equals("Assalariado")) {
						func[index] = FactoryEmployee.getEmployee("A", SVname, SVadress, "Assalariado", SVmetodo , SVcode);
						
					}
					func[index].setAgenda(agenda[list.getSelectedIndex()]);
					func[index].setAgendaID(list.getSelectedIndex());
					func[index].setCustom(custom);
					
				}
				
				//Valores independem de tipo
				if(UT.isFree(func, TFscode.getText()) && TFscode.isVisible()) 
				func[index].setSindicatycode(TFscode.getText());
				func[index].setAgendaID(list.getSelectedIndex());
				
				//set sindicato
				if(CBsind.getSelectedItem().toString().equals("SIM")) {
					func[index].setSindicaty(true);
				} else func[index].setSindicaty(false);
				
				//Salario Base/h Horista
				if(func[index] instanceof Horista) {
					((Horista) func[index]).setSalarioBase(Double.parseDouble(TFvalor.getText()));
					func[index].setSalary(savesalary);
				} 
				
				//Salario de Assalariado e Comissionado
				else {
						func[index].setSalary(Double.parseDouble(TFvalor.getText()));
						if(func[index] instanceof Comissionado) {
							 ((Comissionado)func[index]).setPVenda(Integer.parseInt(TFcomi.getText()));
							 ((Comissionado)func[index]).setPsalary(func[index].getSalary());
							 ((Comissionado)func[index]).setBonussalary(bonus);
							}
				}	
				//Backupsalary, caso haja modificação indevida 
				func[index].setSalarybup(Double.parseDouble(TFvalor.getText()));
				
				//frequencia de dias trabalhados até entao, não serão perdidos
				func[index].setFrequenciaD(savefrequency);
				func[index].setSaved(true);
				
				//savestate
				Command.URpago[index] = false;	
				try {
					Command.saveS(func);
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				
				//apaga scene
				setVisible(false);
				return;
			}
		});
		
		
		
		
		setTitle("Editar Informações");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setSize(612, 532);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
	}
}
