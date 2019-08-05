package com.employee;

import com.adm.CalendarMT;
import com.factoryPattern.FactorySchedule;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;
import com.timecard.TimeCard;
import com.union.Union;

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
	
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
		
	}
	
	public boolean pagarFuncionario() {

		boolean Uday = false;
		
		if(this.agenda instanceof Mensal)
		{
			Uday = ( CalendarMT.Adia >= (((Mensal)this.agenda).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)this.agenda).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
			timecard.setPago(Uday && timecard.frequenciaD >= 30);
			
		}else if(this.agenda instanceof Semanal) {
			 
			timecard.setPago(timecard.frequenciaD >= ((Semanal)this.agenda).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)this.agenda).getDia()));
		}
		if(timecard.isPago()) {
			this.timecard.frequenciaD = 5;
			this.timecard.setURpago(true);
		}
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


















