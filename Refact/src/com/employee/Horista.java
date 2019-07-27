package com.employee;

import com.adm.CalendarMT;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class Horista extends Funcionario implements Cloneable{
	

	public Horista(String name, String adress, String type, String payMode, String code) {
		this.name = name;
		this.adress = adress;
		this.type = type;
		this.payMode = payMode;
		this.code = code;
	}
	
	@Override
	public Horista clone() throws CloneNotSupportedException {
	        return (Horista) super.clone();
	}
	
	protected double salarioBase = 0;
	private double psalary = 0;
	

	public void addSalary(int horas){
		if(horas <= 8) {
			super.salary += horas * salarioBase;
		}else {
			super.salary += 8 * salarioBase;
			horas -= 8;
			super.salary += horas * (salarioBase*1.5);
		}
		
	}
	
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	
	public double getPsalary() {
		return psalary;
	}

	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}

}