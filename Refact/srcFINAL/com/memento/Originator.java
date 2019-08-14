package com.memento;

import com.config.adm.CalendarMT;
import com.elements.employee.Assalariado;
import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.schedule.Agenda;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;

public class Originator {
	
	private Memento memento;
	
	public void setState(Memento memento, Agenda[] agenda, Funcionario[] f) {
		memento = new Memento(agenda, f);
	}
	
	public Memento save() {
		return new Memento(memento.getStateAgenda(), memento.getStateFuncionario());
	}
	
	public void restore(Memento memento, Agenda[] agenda, Funcionario[] func) {
		
		new CopyMaker().doCopy(memento.getStateFuncionario(), memento.getStateAgenda(), func, agenda);
		CalendarMT.payboo = memento.payboo;
		
	}
}
