package com.factoryPattern;

import com.schedule.Agenda;

public interface ScheduleCreation {
	
	  public Agenda getSchedule(String type, String day, int frequency);
	 
}