package com.timecard;

public class TimeCard extends Check{
	
	public boolean pago = false;
	public boolean URpago = false;
	public int timeIN = 0;
	public int timeOUT = 0;
	public int frequenciaD = 0; 
	
	public int getFrequenciaD() {
		return frequenciaD;
	}
	public void setFrequenciaD(int frequenciaD) {
		this.frequenciaD = frequenciaD; 
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public boolean isURpago() {
		return URpago;
	}
	public void setURpago(boolean uRpago) {
		URpago = uRpago;
	}
	public int getTimeIN() {
		return timeIN;
	}
	public void setTimeIN(int timeIN) {
		this.timeIN = timeIN;
	}
	public int getTimeOUT() {
		return timeOUT;
	}
	public void setTimeOUT(int timeOUT) {
		this.timeOUT = timeOUT;
	}
	
	

}
