package com.elements.employee;

import com.config.adm.CalendarMT;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;

public class Comissionado extends Funcionario implements Cloneable{
	
	
	public Comissionado(String name, String adress, String type, String payMode, String code) {
		this.name = name;
		this.adress = adress;
		this.type = type;
		this.payMode = payMode; 
		this.code = code;
	}

	@Override
	public Comissionado clone() throws CloneNotSupportedException {
	        return (Comissionado) super.clone();
	}
	 
	private double valordevendas;
	private double bonussalary = 0; 
	private double psalary = 0;  

	private int pvenda = 15;
	
	@Override
	public String toString() {
		return name + " - " + code +  " - Pago via: " + payMode;
	}
	
	public double getValordevendas() {
		return valordevendas;
	}

	public void setValordevendas(double valordevendas) {
		this.valordevendas = valordevendas;
	}

	public double getBonussalary() {
		return bonussalary;
	}
	
	public void setBonussalary(double bonussalary) {
		this.bonussalary = bonussalary;
	}

	public void addBonussalary(double bonussalary) {
		this.bonussalary += bonussalary;
	}
	
	public int getPVenda() {
		return pvenda;
	}

	public void setPVenda(int pvenda) {
		this.pvenda = pvenda;
	}

	public double getPsalary() {
		return psalary;
	}

	public void setPsalary(double psalary) {
		this.psalary = psalary;
	}
}
