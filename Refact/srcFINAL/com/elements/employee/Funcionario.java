package com.elements.employee;

import com.config.adm.CalendarMT;
import com.config.state.Nivel_1;
import com.config.state.State;
import com.elements.schedule.Agenda;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;
import com.elements.timecard.TimeCard;
import com.elements.union.Union;

public abstract class Funcionario extends Signature implements Cloneable{
	 
	protected String name;
	protected String adress;
	protected double salary;
	protected String payMode;
	protected String type;
	protected String code;
	
	public Union union = new Union();
	public TimeCard timecard = new TimeCard();
	public Agenda agenda = new Agenda();
	private State currentState = new Nivel_1();
	
	public void setState(State s) {
		this.currentState = s;
	}
	
	public String getState() {
		return currentState.toString();
	}
	public void promote() {
		this.currentState.promote(this);
	}
	
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
		
	}
	
	public boolean pagarFuncionario() {

		boolean Uday = false;
	
		Uday = agenda.isValidDay(timecard.frequenciaD);
		timecard.setPago(Uday);
		timecard.pay();
		
		return timecard.isPago();

	}
	
	public Agenda getAgenda() {
		return this.agenda;
	}
	public TimeCard getTimeCard() {
		return this.timecard;
	}
	public Union getUnion() {
		return this.union;
	}
	public String toString() {
		return name + " - " + code +  " - Pago via: " + payMode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
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
	public int getFrequenciaD() {
		return timecard.frequenciaD;
	}
	public void setFrequenciaD(int frequenciaD) {
		this.timecard.frequenciaD = frequenciaD;
	}
	public void addFrequenciaD(int frequenciaD) {
		this.timecard.frequenciaD += frequenciaD;
	}
	public double getSalarybup() {
		return salarybackUP;
	}
	public void setSalarybup(double salarybup) {
		this.salarybackUP = salarybup;
	}
}


















