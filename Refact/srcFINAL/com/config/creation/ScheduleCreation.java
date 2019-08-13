package com.config.creation;

import com.elements.schedule.Agenda;

public interface ScheduleCreation {
	
	  public Agenda getSchedule(String type, String day, int frequency);
	 
}