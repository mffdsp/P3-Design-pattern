package com.cmd;

public final class Singleton{
	
	private static Cmd cmd;
	
	public static Cmd getInstance() {
		  
	        if (cmd == null) {
	        	cmd = new Cmd();
	        }
	        return cmd;
	 }
}
