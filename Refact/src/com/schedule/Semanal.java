package com.schedule;

public class Semanal extends Agenda implements Cloneable, ScheduleBuilder{
	
	private String dia = "Segunda-Feira";
	private Agenda Schedule;
	
	public Semanal(String day, int frequency) {
		
		this.dia = day;
		super.setFrequencia(frequency);
		super.setSaved(true);
	}	

	@Override
	public Semanal clone() throws CloneNotSupportedException {
	     return (Semanal) super.clone();
	}
	 
	@Override
	public String toString() {
		switch(Schedule.getFrequencia())
		{
		case 1: 
			return "Semanal - \"" + Schedule.getFrequencia() + "\" - " + dia;
		case 2: 
			return "Bi-Semanal - \"" + Schedule.getFrequencia() + "\" - " + dia;
		case 3: 
			return "Tri-Semanal - \"" + Schedule.getFrequencia() + "\" - " + dia;
		}
		return "ERRO"; 
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public String getDia() {
		return dia;
	}

	public void SemanalBuilder()  
    { 
        this.Schedule = new Agenda();
    } 
	
	public void buildFrequencia(int frequency) {
		
		Schedule.setFrequencia(frequency);
	}
	
	public void buildIndex(int index) {
		
		Schedule.setIndex(index);
	}
	
	public void buildSaved(boolean saved) {
		
		Schedule.setSaved(saved);
	}
	
	public Agenda getSchedule() {
		
		return this.Schedule;
	}
	

}
