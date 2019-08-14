package com.memento;

import com.elements.employee.Funcionario;
import com.elements.schedule.Agenda;

public interface Copy {
		void doCopy(Funcionario[] f, Agenda[] a, Funcionario[] fm, Agenda[] am);
}
