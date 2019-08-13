package com.elements.employee;

public class Signature {
	
	protected double salarybackUP = 1;
	protected boolean saved = false; 
	protected boolean custom = false;
	protected int agendaID = -1; 
	
	public double getSalarybackUP() {
		return salarybackUP;
	}
	public void setSalarybackUP(double salarybackUP) {
		this.salarybackUP = salarybackUP;
	}
	public boolean isSaved() { 
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public int getAgendaID() {
		return agendaID;
	}
	public void setAgendaID(int agendaID) {
		this.agendaID = agendaID;
	}
	
}
