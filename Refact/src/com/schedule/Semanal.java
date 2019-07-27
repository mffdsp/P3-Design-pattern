package com.schedule;

public class Semanal extends Agenda implements Cloneable{
	
	
	@Override
	public Semanal clone() throws CloneNotSupportedException {
	     return (Semanal) super.clone();
	}
	
	private String dia = "Segunda-Feira";
	
	public String toString() {
		switch(super.getFrequencia())
		{
		case 1: 
			return "Semanal - \"" + super.getFrequencia() + "\" - " + dia;
		case 2: 
			return "Bi-Semanal - \"" + super.getFrequencia() + "\" - " + dia;
		case 3: 
			return "Tri-Semanal - \"" + super.getFrequencia() + "\" - " + dia;
		}
		return "ERRO";
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDia() {
		return dia;
	}
	

}
