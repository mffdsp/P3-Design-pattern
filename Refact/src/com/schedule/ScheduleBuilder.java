package com.schedule;

public interface ScheduleBuilder {
		
	public void buildFrequencia(int frequency); 

	public void buildIndex(int index); 

	public void buildSaved(boolean saved); 
	
	public Agenda getSchedule(); 
}
