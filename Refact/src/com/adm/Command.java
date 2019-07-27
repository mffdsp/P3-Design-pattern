package com.adm;

import javax.swing.JOptionPane;

import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Command {
	
	public static int SSindex = 0;
	public static int UNDOAC = 0;
	public static boolean URpago[] = new boolean[500];
	public static int AgendaIndex = 0;
	public static SaveState[][] SS = new SaveState[500][500];
	
	//For visual
	public static boolean UndoAC = false;
	public static boolean RedoAC = false;
	
	
	//PSV para nao passar por argumento em toda View
	public static void saveS(Funcionario[] func) throws CloneNotSupportedException {
		
    	SSindex += 1;
    	try {
    		for(int i = 0; i < 500; i++) {
				SS[i][SSindex] = new SaveState();				
				//save employee
				if(func[i] instanceof Horista) {
					
					SS[i][SSindex].funcionariosSAVE = new Horista(null, null, null, null, null);
					SS[i][SSindex].funcionariosSAVE = ((Horista)func[i]).clone();
					
				}else if(func[i] instanceof Assalariado) {
					
					SS[i][SSindex].funcionariosSAVE =  new Assalariado(null, null, null, null, null);
					SS[i][SSindex].funcionariosSAVE = ((Assalariado)func[i]).clone();
				}else if(func[i] instanceof Comissionado) {
					
					SS[i][SSindex].funcionariosSAVE =  new Comissionado(null, null, null, null, null);
					SS[i][SSindex].funcionariosSAVE = ((Comissionado)func[i]).clone();
				}
				//save schedules
				if(func[i].getAgenda() instanceof Mensal) {
					
					SS[i][SSindex].agendasSAVE = new Mensal();
					SS[i][SSindex].agendasSAVE = ((Mensal)func[i].getAgenda()).clone();
				}else if(func[i].getAgenda() instanceof Semanal) {
					
					SS[i][SSindex].agendasSAVE = new Semanal();
					SS[i][SSindex].agendasSAVE = ((Semanal)func[i].getAgenda()).clone();
					
				}
				//save Payroll state
				SS[i][SSindex].payboo = CalendarMT.payboo[i];
			}
    	}catch(Exception ex) {
    		System.err.println(ex);
    	}	
			
		}
	
	public static void UR_ACTION(Funcionario[] func, String action){
		
		if(SSindex == 1 && action.equals("UNDO")) {
			System.out.println("EMPTY/ENDOF STACK");
			return;
		}else if (action.equals("REDO") && (UNDOAC == 0 || SS[0][SSindex + 1] == null) ) {
			System.out.println("EMPTY/ENDOF STACK");
			return;
		}
			
		if(action.equals("UNDO")) {
				UndoAC = true;
				UNDOAC += 1;
				SSindex -= 1;
		}else if(action.equals("REDO")) {
				RedoAC = true;
				UNDOAC -= 1;
				SSindex += 1;
		}
		//Nullpointer (?)
		try {
			for(int i = 0; i < 500; i++) {
				
				//employee DATA
				if(SS[i][SSindex].funcionariosSAVE instanceof Comissionado) {
					
					func[i] = new Comissionado(null, null, null, null ,null);
					func[i] = ((Comissionado)SS[i][SSindex].funcionariosSAVE).clone();
					
				}else if(SS[i][SSindex].funcionariosSAVE instanceof Horista) {
					
					func[i] =  new Horista(null, null, null, null, null);
					func[i] = ((Horista)SS[i][SSindex].funcionariosSAVE).clone();
					
				}else if(SS[i][SSindex].funcionariosSAVE instanceof Assalariado) {
					
					func[i] =  new Assalariado(null, null, null, null, null);
					func[i] = ((Assalariado)SS[i][SSindex].funcionariosSAVE).clone();
				}
					//undo schedules DATA
				if(SS[i][SSindex].agendasSAVE instanceof Mensal) {
					
					func[i].agenda = new Mensal();
					func[i].setAgenda(SS[i][SSindex].agendasSAVE);
					
				}else if(SS[i][SSindex].agendasSAVE instanceof Semanal) {
					
					func[i].agenda = new Semanal();
					func[i].setAgenda(SS[i][SSindex].agendasSAVE);
					
				}
				//Payroll DATA
				CalendarMT.payboo[i] = SS[i][SSindex].payboo;
				
				}
		}catch(Exception ex) {		
			System.err.println(ex);
		}
	}
	
	
}
