package com.memento;

import java.util.ArrayList;

public class CareTaker {
	private static ArrayList<Memento> mementos =  new ArrayList<>();
	
	public void addMemento(Memento memento) {
		mementos.add(memento);
	}
	
	public static ArrayList<Memento> getMementos(){
		return mementos;
	}
	
	public Memento getMemento() {
		
		return mementos.get(mementos.size()-2);
	}
	
}
