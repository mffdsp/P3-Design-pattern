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
	
	public double getPsalary() {
		return psalary;
	}
	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}

}
