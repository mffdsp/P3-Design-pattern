package com.config.cmd;

import com.memento.CareTaker;
import com.memento.Memento;
import com.memento.Originator;

public final class Singleton{

	private static Cmd cmd;
	private static Memento memento;
	private static Originator originator;
	private static CareTaker careTaker;
	
	public static Cmd getInstance() {

		if (cmd == null) {
			cmd = new Cmd();
		}
		return cmd;
	}
	
	public static Memento getInstanceMemento() {

		if (memento == null) {
			memento = new Memento(null, null);
		}
		return memento;
	}
	
	public static Originator getInstanceOriginator() {

		if (originator == null) {
			originator = new Originator();
		}
		return originator;
	}

	public static CareTaker getInstanceCareTaker() {

		if (careTaker == null) {
			careTaker = new CareTaker();
		}
		return careTaker;
	}

	
}