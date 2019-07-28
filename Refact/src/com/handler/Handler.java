package com.handler;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.adm.CalendarMT;
import com.adm.Utility;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.SignUP;
import com.view.ListView;
import com.view.MainView;
import com.view.PayView;

public class Handler {
	
	Utility UT = new Utility();
	
	public void ListViewHandler(Funcionario[] funcionarios){
		
		DefaultListModel DLMA = new DefaultListModel();
		DefaultListModel DLMC = new DefaultListModel();
		DefaultListModel DLMH = new DefaultListModel();
		try {
			UT.setList(funcionarios, DLMC, DLMA, DLMH);
		}
		catch(NullPointerException e) {
			System.err.println("Exception de ponteiro nulo");
		}
		if(DLMA.getSize() == 0) {
			DLMA.addElement("Lista Vazia");
		}if(DLMH.getSize() == 0) {
			DLMH.addElement("Lista Vazia");
		}if(DLMC.getSize() == 0) {
			DLMC.addElement("Lista Vazia");
		}
		new ListView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
	}
	
	public void addViewHandler(Funcionario[] funcionarios) {
		
		MainView.index = UT.findIndex(funcionarios);
		funcionarios[MainView.index] = new Horista(null, null, null, null, null);
		try {
			new SignUP(funcionarios, MainView.index).setVisible(true);
			
		}catch(ArrayIndexOutOfBoundsException exception) {
			
			System.err.println("Indice fora dos limites definidos");
		}
	}
	
	public void folhaViewHandler(Funcionario[] funcionarios) {
		
		if(CalendarMT.payboo[CalendarMT.DAYSGONE]){
			JOptionPane.showMessageDialog(null ,
					"Folha de pagamento já rodada hoje", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja rodar a folha de pagamento para hoje?", "Confirmação", dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			CalendarMT.payboo[CalendarMT.DAYSGONE] =  true;
			DefaultListModel DLMA = new DefaultListModel();
			DefaultListModel DLMC = new DefaultListModel();
			DefaultListModel DLMH = new DefaultListModel();
			try{ 
				UT.payList(funcionarios, DLMC, DLMA, DLMH);
			}
			catch(NullPointerException e2) {
				System.err.println("Exception de ponteiro nulo");
			}
			if(DLMA.getSize() == 0) {
				DLMA.addElement("Lista Vazia");
			}if(DLMH.getSize() == 0) {
				DLMH.addElement("Lista Vazia");
			}if(DLMC.getSize() == 0) {
				DLMC.addElement("Lista Vazia");
			}		
			try {
				new PayView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public void timeViewHandler(JLabel LBdata, JLabel LBhora, Funcionario[] funcionarios) {
		
		CalendarMT.passHour(funcionarios);
		LBdata.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
		+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
		LBhora.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
	}
	

}
