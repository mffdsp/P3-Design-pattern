//package com.memento;
//
//import com.adm.Command;
//import com.adm.SaveState;
//import com.employee.Funcionario;
//
//public class Originator {
//	
//	  private static SaveState[] state;
//
//	  public void setState(SaveState[] state) {
//	        System.out.println("Originator: Setting state to " + state);
//	        this.state = state;
//	  }
//
//	  public static Memento save(Funcionario[] func) throws CloneNotSupportedException {
//	        System.out.println("Originator: Saving to Memento.");
//	        return new Memento(state);
//	  }
//	  
//	  public void restore(Memento m) {
//	        state = m.getState();
//	        System.out.println("Originator: State after restoring from Memento: " + state);
//	  }
//}
