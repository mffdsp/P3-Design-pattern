package com.adm;

import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class SaveState{

	protected Funcionario funcionariosSAVE = new Horista(null, null, null , null, null);
	protected Agenda agendasSAVE = new Agenda();
	protected boolean URpago = false;
	protected boolean payboo = false;

}
