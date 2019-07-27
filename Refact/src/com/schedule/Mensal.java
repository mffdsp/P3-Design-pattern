package com.schedule;

import com.employee.Assalariado;

public class Mensal extends Agenda implements Cloneable{
	
	
	@Override
	public Mensal clone() throws CloneNotSupportedException {
	     return (Mensal) super.clone();
	}
	 
	private int dia = 0;
	
	public String toString() {
		return "Mensal - " + dia;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
}
