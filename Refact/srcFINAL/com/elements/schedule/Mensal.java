package com.elements.schedule;

public class Mensal extends Agenda implements Cloneable, Config{
	
	private int dia = 0;
	private Agenda Schedule;
	
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

	public void setDia(int dia){
		this.dia = dia; 
	}

	public void MensalBuilder(){ 
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
	@Override
	public void reset() {

		this.setDia(-1);
		this.setIndex(-1);
		this.setSaved(false);
		this.setFrequencia(0);
	}
}
