package com.elements.schedule;

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

}
