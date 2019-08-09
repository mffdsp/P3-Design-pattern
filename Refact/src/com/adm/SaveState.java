package com.adm;

import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class SaveState{

	public Funcionario funcionariosSAVE = new Horista(null, null, null , null, null);
	public Agenda agendasSAVE = new Agenda();
	protected boolean URpago = false;
	public boolean payboo = false; 
 
}
