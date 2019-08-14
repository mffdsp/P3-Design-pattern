package com.config.adm;

import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.schedule.Agenda;

public class SaveState{

	public Funcionario funcionariosSAVE = new Horista(null, null, null , null, null);
	public Agenda agendasSAVE = new Agenda();
	protected boolean URpago = false;
	public boolean payboo = false; 
	
	public Agenda getAgenda() {
		return this.agendasSAVE;
	}
 
}