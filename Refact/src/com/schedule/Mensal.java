package com.schedule;

import com.employee.Assalariado;

public class Mensal extends Agenda implements Cloneable{
	
	private int dia = 0;
	
	public Mensal(String day, int frequency) {
		
		this.dia = Integer.parseInt(day);
		super.setFrequencia(frequency);
		super.setSaved(true);
	}	
	@Override
	public Mensal clone() throws CloneNotSupportedException {
	     return (Mensal) super.clone();
	} 
	

	
	@Override
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
