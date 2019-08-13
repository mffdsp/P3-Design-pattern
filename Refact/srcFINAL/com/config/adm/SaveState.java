package com.config.adm;

import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.schedule.Agenda;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;

public class SaveState{

	public Funcionario funcionariosSAVE = new Horista(null, null, null , null, null);
	public Agenda agendasSAVE = new Agenda();
	protected boolean URpago = false;
	public boolean payboo = false; 
 
}
