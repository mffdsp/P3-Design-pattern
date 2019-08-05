package com.payroll;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import com.adm.Utility;
import com.builder.RealEditBuilder;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.factoryPattern.FactoryEmployee;
import com.factoryPattern.FactorySchedule;
import com.label.LBpattern;
import com.memento.Command;
import com.memento.Memento;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class RealEdit extends JFrame {

	JTextField TFscode = new JTextField();
	public static int acc = 1;
	public static boolean custom = false;
	Utility UT = new Utility();
	

	public RealEdit(Funcionario[] func, int index, Agenda[] agenda){
		
		JPanel contentPane = new JPanel();
		RealEditBuilder buildScreen = new RealEditBuilder();
		LBpattern lbpattern = new LBpattern(); 
		
		custom = func[index].isCustom();
		
		buildScreen.config(this, contentPane);
		
		buildScreen.config(contentPane);
		setContentPane(contentPane);

		
		
		JLabel LBadress = new JLabel("Endere\u00E7o:");
		JLabel LBname = new JLabel("Nome:");
		JLabel LBvalor = new JLabel("Valor:");
		JLabel LBicon1 = new JLabel("");
		JLabel LBmetodo = new JLabel("M\u00E9todo de pagamento:");
		JLabel LBtipo = new JLabel("Tipo de funcin\u00E1rio:");
		JLabel LBcomi = new JLabel("Comiss\u00E3o de venda :");
		JLabel LBpcomi = new JLabel("%");
		JLabel LBrs = new JLabel("R$");
		JLabel LBscode = new JLabel("S. Code:");
		JLabel LBindisponivel = new JLabel("indisponivel");
		JLabel LBsind = new JLabel("Sindicato:");
		JLabel LBicon2 = new JLabel("");
		
		JTextField TFvalor = new JTextField();
		JTextField TFadress = new JTextField();
		JTextField TFname = new JTextField();
		JTextField TFcomi = new JTextField();
		JTextField TFscode = new JTextField();
		 
		JButton BTsave = new JButton("Salvar");
		JButton TFcustom = new JButton("Custom Schedule");
		
		JList list = new JList();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JComboBox CBmetodo = new JComboBox();
		JComboBox CBtipo = new JComboBox();
		JComboBox CBsind = new JComboBox();
		
		buildScreen.addTF(contentPane, TFvalor, TFadress, TFname, TFcomi, TFscode, TFcustom, func[index]);
		lbpattern.addLBL(LBadress, contentPane, 28, 164, 93, 21);
		lbpattern.addLBL(LBname, contentPane, 28, 128, 56, 21);
		lbpattern.addLBL(LBvalor, contentPane, 26, 386, 71, 21);
		lbpattern.addLBL(LBicon1, contentPane, 28, 11, 145, 107);
		lbpattern.addLBL(LBmetodo, contentPane,28, 352, 202, 21);
		lbpattern.addLBL(LBtipo, contentPane, 28, 196, 202, 21);
		lbpattern.addLBL(LBcomi, contentPane, 26, 418, 164, 21);
		lbpattern.addLBL(LBpcomi, contentPane, 260, 417, 71, 21);
		lbpattern.addLBL(LBrs, contentPane, 137, 386, 71, 21);
		lbpattern.addLBL(LBscode, contentPane, 260, 66, 92, 21);
		lbpattern.addLBL(LBindisponivel, contentPane,362, 94, 87, 21);
		lbpattern.addLBL(LBsind, contentPane, 260, 34, 92, 21);
		lbpattern.addLBL(LBicon2, contentPane, 28, 247, 106, 107);
	
		lateConfig(LBicon1, LBicon2, LBrs);
		
		setCB(CBmetodo, CBtipo, CBsind, func[index].getPayMode());	
		setValue(func[index], TFcomi, LBrs, LBcomi, LBpcomi, CBtipo);
		setSindicaty(func[index], CBsind, TFscode, LBscode, LBindisponivel);
		setList(func[index], list, agenda, scrollPane_1, contentPane);
		
		buildScreen.setAction(TFcustom, agenda, list, scrollPane_1, CBtipo , LBcomi, LBpcomi, TFcomi, LBrs, contentPane);
		
		BTsave.setBounds(501, 337, 93, 158);
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
				setVerify(func, index, LBindisponivel, TFscode, TFcomi, TFvalor, TFname, TFadress, CBmetodo, CBtipo, CBsind, list, agenda);
			}
			
		});
		
		contentPane.add(CBmetodo);
		contentPane.add(CBtipo);
		contentPane.add(CBsind);
		contentPane.add(BTsave);	
		
	}
	
	public void lateConfig(JLabel LBicon1, JLabel LBicon2, JLabel LBrs) {
		
		LBicon1.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-gest\u00E3o-de-cliente-100.png")));
		LBicon2.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-caro-64.png")));
		LBrs.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	public void setValue(Funcionario func, JTextField TFcomi, JLabel LBrs, JLabel LBcomi, JLabel LBpcomi, JComboBox CBtipo) {
		
		switch(func.getType()) {
		case "Horista":
			TFcomi.setText("15");
			LBrs.setText("R$/hora");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func.getType(), "Assalariado", "Comissionado"}));
			break;
		case "Comissionado":
			LBrs.setText("R$");
			TFcomi.setText(Integer.toString(((Comissionado) func).getPVenda()));
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func.getType(), "Horista", "Assalariado"}));
			break;
		case "Assalariado":
			TFcomi.setText("15");
			LBrs.setText("R$");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func.getType(), "Horista", "Comissionado"}));
			break;
		}
	}

	
	public void setSindicaty(Funcionario func, JComboBox CBsind, JTextField TFscode, JLabel LBscode, JLabel LBindisponivel){
		
		if(func.union.isSindicaty()) {
			CBsind.setModel(new DefaultComboBoxModel(new String[] {"SIM", "NAO"}));
			LBindisponivel.setVisible(false);
			TFscode.setText(func.union.getSindicatycode());
		}else {
			CBsind.setModel(new DefaultComboBoxModel(new String[] {"NAO", "SIM"}));
			LBindisponivel.setVisible(false);
			LBscode.setVisible(false);
			TFscode.setVisible(false);
		}
		
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
	}
	
	public void setCB(JComboBox CBmetodo, JComboBox CBtipo, JComboBox CBsind, String paymode) {
		
		CBmetodo.setModel(new DefaultComboBoxModel(new String[] { paymode, "Maos", "Deposito"}));
		CBtipo.setModel(new DefaultComboBoxModel(new String[] { paymode, "Assalariado", "Comissionado"}));
		
		CBmetodo.setBounds(224, 355, 140, 20);
		CBtipo.setBounds(287, 196, 140, 20);
		CBsind.setBounds(362, 35, 65, 20);
	}
	
	public void setList(Funcionario func, JList list, Agenda[] agenda, JScrollPane scrollPane_1, JPanel contentPane) {
		
		if(func.isCustom())
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
			contentPane.add(list); 
			contentPane.add(scrollPane_1);
			list.setModel(DLMA);
			list.setSelectedIndex(func.getAgendaID());
			func.setCustom(true);
			scrollPane_1.setViewportView(list);
		}
	}
	
	public void setVerify(Funcionario[] func, int index, JLabel LBindisponivel, JTextField TFscode, JTextField TFcomi, JTextField TFvalor, JTextField TFname, JTextField TFadress, JComboBox CBmetodo, JComboBox CBtipo, JComboBox CBsind, JList list, Agenda[] agenda) {
		//
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
		if(!UT.isFree(func, TFscode.getText()) && TFscode.isVisible() && !TFscode.getText().equals(func[index].union.getSindicatycode())) {
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
		
		FactorySchedule factorySchedule = new FactorySchedule();
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja salvar as informações?", "Confirmação", dialogButton);
		if(!(dialogResult == JOptionPane.YES_OPTION) ){
			return;
		}
		
		String SVname = TFname.getText();
		String SVadress = TFadress.getText();
		String SVmetodo = CBmetodo.getSelectedItem().toString();
		String SVcode = "2019" + index;
		
		try {
			if(CBtipo.getSelectedItem().toString().equals("Assalariado") && !custom) {
				
				func[index] = FactoryEmployee.getEmployee("A", SVname, SVadress, "Assalariado", SVmetodo , SVcode);
				func[index].setType("Assalariado");

				Agenda nocustom = factorySchedule.getSchedule("Mensal", "30", 1);
				
				((Mensal)nocustom).setDia(30);
				nocustom.setFrequencia(1);
				func[index].setAgenda(nocustom);
				
			}else if(CBtipo.getSelectedItem().toString().equals("Horista")  && !custom) {
				
				func[index] = FactoryEmployee.getEmployee("H", SVname, SVadress, "Horista", SVmetodo , SVcode);
				func[index].setType("Horista");
				
				Agenda nocustom = factorySchedule.getSchedule("Semanal", "Sexta-Feira", 1);
				
				((Semanal)nocustom).setDia("Sexta-Feira");
				nocustom.setFrequencia(1);
				func[index].setAgenda(nocustom);
				
			}else if(CBtipo.getSelectedItem().toString().equals("Comissionado") && !custom ) {
				
				func[index] = FactoryEmployee.getEmployee("C", SVname, SVadress, "Comissionado", SVmetodo , SVcode);
				func[index].setType("Comissionado");
				
				Agenda nocustom = factorySchedule.getSchedule("Semanal", "Sexta-Feira", 2);

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
		func[index].getUnion().setSindicatycode(TFscode.getText());
		func[index].setAgendaID(list.getSelectedIndex());
		
		//set sindicato
		if(CBsind.getSelectedItem().toString().equals("SIM")) {
			func[index].getUnion().setSindicaty(true);
		} else func[index].getUnion().setSindicaty(false);
		
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
		
		Command.URpago[index] = false;	
		Memento.saveState(func); 
		} catch(Exception ex) {
			System.err.println(ex);
		}
		//apaga scene
		setVisible(false);
		return;
		
		//
	}
	
}
