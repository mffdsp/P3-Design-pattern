package com.employee;

import com.adm.CalendarMT;
import com.schedule.Mensal;
import com.schedule.Semanal;

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
	
	
	public boolean pagarFuncionario() {
 
		boolean Uday = false;
		
		if(super.agenda instanceof Mensal)
		{
			Uday = ( CalendarMT.Adia >= (((Mensal)super.agenda).getDia() - 2) && CalendarMT.weekday.equals("Sexta-Feira") ) ||
					(CalendarMT.Adia == ((Mensal)super.agenda).getDia() && !CalendarMT.weekday.equals("Domingo")&& !CalendarMT.weekday.equals("Sabado"));
			
			setPago(Uday && frequenciaD >= 30);
			
		}else if(super.agenda instanceof Semanal) {
			
			setPago(frequenciaD >= ((Semanal)super.agenda).getFrequencia()*7 && CalendarMT.weekday.equals(((Semanal)super.agenda).getDia()));
		}
		if(isPago()) {
			super.frequenciaD = 5; 
			super.setURpago(true);
		}
		return isPago();

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
