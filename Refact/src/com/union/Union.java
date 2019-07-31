package com.union;

public class Union {
	
	public boolean sindicaty = false;
	public String Scode = "notset";
	
	public boolean isSindicaty() {
		return sindicaty;
	}
	public void setSindicaty(boolean sindicaty) {
		this.sindicaty = sindicaty;
	}
	public void setSindicatycode(String Scode) {
		this.Scode = Scode;
	}
	public String getSindicatycode() {
		return this.Scode;
	}
}
