package com.adm;

import javax.swing.JLabel;

import com.employee.Funcionario;
import com.memento.Cmd;

public class CalendarMT {
	
	 public static int Ahora = 15;
	 public static int Aminuto = 20;
	 public static int Adia = 1;
	 public static int Ames = 6;
	 public static int Aano = 2019; 
	 public static boolean[] payboo =  new boolean[500];
	 public static int DAYSGONE = 0; 
	 public static String weekday = "Domingo";
	
	 public static String valueToString(int value) {
		 if(value < 10) {
			 return "0" + value;
		 }
		 else return Integer.toString(value);
	 }
	  
	 public static void passHour(Funcionario[] func) {
		 
		 int auxiliandinho = Ahora;
		 
		 Ahora = (Ahora + 1) % 24;
	     if(Ahora == 0 && auxiliandinho == 23)
	     {
	         timeChange(func);
	     } 
	 }
	 public static void passMinute(Funcionario[] func) {
		 
		 int auxiliandinho = Aminuto;
		 
		 Aminuto = (Aminuto + 1) % 60;
	     if(Aminuto == 59 && auxiliandinho == 58)
	     {
	    	 passHour(func);
	     }
	 }
     
	 public static void timeChange(Funcionario[] func){
		 	
		 	for(int i = 0; i < 500; i++) {
    		 func[i].timecard.setCheckIN(false);
    		 func[i].timecard.setCheckOUT(false);
    		 func[i].addFrequenciaD(1);
    		 func[i].timecard.setURpago(false);
    	     Cmd.URpago[i] = false;
				
	    	}
		 	DAYSGONE += 1;
		 	if(DAYSGONE%7 == 0) {
		 		weekday = "Domingo";
		 	}
		 	if(DAYSGONE%7 == 1) {
		 		weekday = "Segunda-Feira";
		 	}
		 	if(DAYSGONE%7 == 2) {
		 		weekday = "Terca-Feira";
		 	}
		 	if(DAYSGONE%7 == 3) {
		 		weekday = "Quarta-Feira";
		 	}
		 	if(DAYSGONE%7 == 4) {
		 		weekday = "Quinta-Feira";
		 	}
		 	if(DAYSGONE%7 == 5) {
		 		weekday = "Sexta-Feira";
		 	}
		 	if(DAYSGONE%7 == 6) {
		 		weekday = "Sabado";
		 	}
 
	        int aux = Adia;

	        if(Adia == 30 && Ames == 12)
	        {
	            Aano += 1;
	            //PAY_DAY = true;
	        }
	        Adia = Adia%30 + 1; 

	        if(aux == 30 && Adia == 1)
	        {
	            Ames = (Ames%12 + 1);  
	            //PAY_DAY = true;
	        }
	        //findVALIDPAYDAY();
	    }	
	 
	 public static void clock(JLabel l1, JLabel l2, JLabel l3, Funcionario[] func) {
		 Thread clock = new Thread() {
			 
			 public void run() {
				 try {
					 for(;;) {
					passMinute(func);
					l1.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
					+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
					l2.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
					sleep(1000);
					l3.setText(CalendarMT.getWeekDay());
					 }
				 }catch(Exception e) {
					 System.err.print(e);
				 }
			 }
		 };
		 clock.start();
	 }
	 
	 public static String getWeekDay() {
		 return weekday;
	 }

}
