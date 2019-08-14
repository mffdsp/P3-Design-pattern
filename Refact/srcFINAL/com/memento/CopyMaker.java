package com.memento;

import com.config.creation.FactorySchedule;
import com.elements.employee.Assalariado;
import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.schedule.Agenda;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;

public class CopyMaker implements Copy{
	
	public void doCopy(Funcionario[] func, Agenda[] agenda, Funcionario[] f, Agenda[] a) {
		try {
		for(int i = 0; i < 500; i++) {

			if(func[i] instanceof Comissionado) {

				f[i] = new Comissionado(null, null, null, null ,null);
				f[i] = ((Comissionado)func[i]).clone();

			}else if(func[i] instanceof Horista) {

				f[i] =  new Horista(null, null, null, null, null);
				f[i] = ((Horista)func[i]).clone();

			}else if(func[i] instanceof Assalariado) {
				
				f[i] =  new Assalariado(null, null, null, null, null);
				f[i] = ((Assalariado)func[i]).clone();
			}
			//undo schedules DATA
			if(agenda[i] instanceof Mensal) {

				a[i] =  new FactorySchedule().getSchedule("Mensal", "30", 0);
				a[i] = ((Mensal) agenda[i]).clone();

			}else if(agenda[i] instanceof Semanal) {
				
				a[i] = new FactorySchedule().getSchedule("Semanal", "30", 0);
				a[i] = ((Semanal) agenda[i]).clone();

			}
		}
		}catch(Exception e) {
			System.err.println(e);
		}
	}
		
		
}
