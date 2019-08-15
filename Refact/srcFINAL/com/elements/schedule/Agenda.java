package com.elements.schedule;

import com.config.adm.CalendarMT;
import com.elements.timecard.TimeCard;

public class Agenda implements Cloneable, SchedulePlan{
	
	 
	private int frequencia = 0; 
	private int index = 0;
	private boolean saved = false;
	 
	public int getFrequencia() {
		return frequencia; 
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	} 
	
	public boolean isValidDay(int frequency) {

		boolean uday = false;
	
		if(this instanceof Mensal) 

			uday = ( CalendarMT.Adia >= (((Mensal)this).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)this).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
		if(this instanceof Semanal) {
			 
			uday = frequency >= ((Semanal)this).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)this).getDia());
		}
		
		return uday;

	}
	

}
