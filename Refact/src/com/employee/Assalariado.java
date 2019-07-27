package com.employee;

import com.adm.CalendarMT;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Assalariado extends Funcionario implements Cloneable{
	
	public Assalariado(String name, String adress, String type, String payMode, String code) {
		this.name = name;
		this.adress = adress;
		this.type = type;
		this.payMode = payMode;
		this.code = code;
	}

	
	 @Override
	 public Assalariado clone() throws CloneNotSupportedException {
	     return (Assalariado) super.clone();
	 }
	 
	private double psalary = 0;
	
		
	public boolean pagarFuncionario() {

		boolean Uday = false;
		
		if(super.agenda instanceof Mensal)
		{
			Uday = ( CalendarMT.Adia >= (((Mensal)super.agenda).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)super.agenda).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
			setPago(Uday && getFrequenciaD() >= 30);

		}else if(super.agenda instanceof Semanal) {

			setPago(getFrequenciaD() >= ((Semanal)super.agenda).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)super.agenda).getDia()));
		}
		if(isPago()) {
			super.frequenciaD = 5;
			super.setURpago(true);
		}
		return isPago();

	}

	public double getPsalary() {
		return psalary;
	}
	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}

}
