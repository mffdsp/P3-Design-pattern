package com.config.creation;

import com.elements.schedule.Agenda;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;

public class FactorySchedule implements ScheduleCreation{

	@Override
    public Agenda getSchedule(String type, String day, int frequency) {
		
        if (type.equals("Mensal")) 
            return new Mensal(day, frequency);
        if (type.equals("Semanal"))
        	return new Semanal(day, frequency);
        else 
        	System.err.println("Argumento invalido");
        	return null;
    }
	
	public String toString(Agenda agenda) {
		
		if(agenda instanceof Semanal) {
			return ((Semanal) agenda).toString();
		} else return ((Mensal) agenda).toString();
		
	}
   
}
