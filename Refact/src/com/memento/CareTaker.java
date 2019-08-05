package com.memento;

import java.util.ArrayList;

public class CareTaker {
	
    private static ArrayList<Memento> mementos = new ArrayList<>();
	 
	Memento memento[] = new Memento[500];
	
	public static void addMemento(Memento memento) {
		mementos.add(memento);
	}
	
	public static Memento getMemento() {
	    return mementos.get(1);
	}
}
