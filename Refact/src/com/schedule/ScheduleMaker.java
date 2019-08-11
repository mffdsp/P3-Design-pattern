package com.schedule;

public class ScheduleMaker {
	
	private Agenda Mensal;
	private Agenda Semanal;
	
	public ScheduleMaker() {
		
		Mensal = new Mensal("30", 30);
		Semanal = new Semanal("Sexta-Feira", 15);
	}
	
	public Agenda resetSemanal() {
		
		((Semanal) Semanal).reset();
		return Semanal;
		
	}
	
	public Agenda resetMensal() {
		
		((Mensal) Mensal).reset();
		return Mensal;
	}
	
}
