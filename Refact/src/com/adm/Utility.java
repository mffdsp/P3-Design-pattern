package com.adm;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.memento.Cmd;
import com.schedule.Agenda;
import com.schedule.Semanal;
import com.view.MainView;

public class Utility {
	

	public int findIndex(Funcionario[] func) {
		for(int i = 0; i < 500; i++)
		{
			if(!func[i].isSaved()) 
			{
				return i;
			}
		}
		return -1;
		
	}
	 
	public int getIndex(String codigo){
        int i = 0;
        int index = 0; 
        //2019265
        int pt = codigo.length() - 5;
        while(i < codigo.length() - 4 ) 
        {
            index += Math.pow(10, pt - i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
	}
	
	public boolean isFree(Funcionario[] func, String newScode) {
		for(int i = 0; i < 500; i++)
		{
			if(func[i].getUnion().getSindicatycode().equals(newScode) && func[i].getUnion().isSindicaty() && func[i].isSaved())
			{
				return false;
			}
		}
		return true;
	}
	
	public int findFuncSind(Funcionario[] func, String newScode) {
		for(int i = 0; i < 500; i++)
		{
			if(func[i].getUnion().getSindicatycode().equals(newScode) && func[i].getUnion().isSindicaty() && func[i].isSaved())
			{
				return i;
			}
		}
		return -1;
	}
	
	public void setALL(Funcionario[] func, Agenda[] agenda) {
		for(int i = 0; i < 500; i++)
		{
			try {
				
				func[i] = new Horista(null, null, null, null, null);
				func[i].setType("Horista");
				CalendarMT.payboo[i] = false;
				agenda[i] = new Agenda();
				agenda[i].setSaved(false);
				Cmd.URpago[i] = false;
				
			}catch(Exception e){
				System.err.println(e);
			}
			
		}
	}
	
	public void setList(Funcionario[] teste, DefaultListModel DLMC, DefaultListModel DLMA, DefaultListModel DLMH) {
		for(int i = 0; i < 500; i++) { 
			if(teste[i].isSaved())
			{
				if(teste[i].getType().equals("Assalariado")){
					DLMA.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}if(teste[i].getType().equals("Comissionado") && teste[i].isSaved() ){
					DLMC.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}if(teste[i].getType().equals("Horista") && teste[i].isSaved()){
					DLMH.addElement(teste[i].getName() + " - " + teste[i].getCode());	
				}
			}
			
		}
	}
	
	public void payList(Funcionario[] teste, DefaultListModel DLMC, DefaultListModel DLMA, DefaultListModel DLMH) {
		for(int i = 0; i < 500; i++) { 
			if(teste[i].isSaved())
			{ 
				boolean pay = false;
				
				try {
					pay = teste[i].pagarFuncionario();
				}catch(Exception ex) {
					System.err.println(ex);
				}
				
				
				//SE ASSALARIADO
				if(teste[i] instanceof Assalariado && (pay || Cmd.URpago[i])){
					
					if(pay) {
						Cmd.URpago[i] = true;
					}
					DLMA.addElement(teste[i].toString());
					if(teste[i].getAgenda() instanceof Semanal) {
						if(teste[i].getAgenda().getFrequencia() == 1) {
							((Assalariado)teste[i]).setPsalary(teste[i].getSalary()/4);
						}else if(teste[i].getAgenda().getFrequencia() == 2) {
							((Assalariado)teste[i]).setPsalary(teste[i].getSalary()/2);
						}else if(teste[i].getAgenda().getFrequencia() == 3) {
							((Assalariado)teste[i]).setPsalary(teste[i].getSalary() *3/4);
						}
					}else ((Assalariado)teste[i]).setPsalary(teste[i].getSalary());
					
					teste[i].setSalary(teste[i].getSalarybup());
					
				}
				//SE COMISSIONADO
				if(teste[i] instanceof Comissionado && (pay || Cmd.URpago[i])){
					
					if(pay) {
						Cmd.URpago[i] = true;
					}
					DLMC.addElement(teste[i].toString());	
					
					if(teste[i].getAgenda() instanceof Semanal) {
						if(teste[i].getAgenda().getFrequencia() == 1) {
							((Comissionado)teste[i]).setPsalary(teste[i].getSalary()/4 + ((Comissionado)teste[i]).getBonussalary());
						}else if(teste[i].getAgenda().getFrequencia() == 2) {
							((Comissionado)teste[i]).setPsalary(teste[i].getSalary()/2 + ((Comissionado)teste[i]).getBonussalary());
						}else if(teste[i].getAgenda().getFrequencia() == 3) {
							((Comissionado)teste[i]).setPsalary(teste[i].getSalary() * 3/4 + ((Comissionado)teste[i]).getBonussalary());
						}
					}else {
						((Comissionado)teste[i]).setPsalary(teste[i].getSalary() + ((Comissionado)teste[i]).getBonussalary());
					}
					((Comissionado)teste[i]).setBonussalary(0);
					teste[i].setSalary(teste[i].getSalarybup());
					
				}
				//SE Horista
				if(teste[i] instanceof Horista && (pay || Cmd.URpago[i])){
					
					if(pay) {
						Cmd.URpago[i] = true;
					}
					DLMH.addElement(teste[i].toString());
					((Horista)teste[i]).setPsalary(teste[i].getSalary());
					teste[i].setSalary(0);
				}
			}
			
		}
	}
	
	public void ERRO() {
		JOptionPane.showMessageDialog(null ,
				"Preencha todos os campos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
	}
	
	 public void UR(JLabel LBur, JButton UndoBTN, JButton RedoBTN) {
		 Thread undo = new Thread() {
			 public void run() {
				 try {
					for(;;) {
						//att text
						if(Cmd.UndoAC) {
							LBur.setForeground(new Color(255, 165, 0));
							LBur.setText("Undone!");
							Cmd.UndoAC = false;
							sleep(500);
						}else if(Cmd.RedoAC) {
							LBur.setForeground(new Color(30, 144, 255));
							LBur.setText("Redone!");
							Cmd.RedoAC = false;
							sleep(500);
						}
						LBur.setText("");
						
						//att icon
						if(Cmd.SSindex == 1) {
							UndoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-desfazer-32 (2).png")));
						}else UndoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-desfazer-32 (3).png")));
						if(Cmd.UNDOAC == 0 || Cmd.SS[0][Cmd.SSindex + 1] == null) {
							RedoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-refazer-32 (1).png")));
						}else RedoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-refazer-32.png")));
						
					}
				}catch(Exception e) {
					 System.err.print(e);
				 }
		 }
		};
		 undo.start();
	 }

}
