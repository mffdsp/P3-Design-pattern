package com.memento;

import com.config.adm.CalendarMT;
import com.elements.employee.Funcionario;
import com.elements.schedule.Agenda;

public class Memento {
	
	Funcionario[] f = new Funcionario[1000];
	Agenda[] a = new Agenda[1000];
	
	public Funcionario[] getStateFuncionario() {
		return f;
	}
	
	public Agenda[] getStateAgenda() {
		return a;
	}

	public Memento(Agenda[] agenda, Funcionario[] func) {
	
		new CopyMaker().doCopy(func, agenda, f, a);
		payboo = CalendarMT.payboo;
		
		
	}

}
