package com.config.command;

import javax.swing.JFrame;

public class DrawCommand extends Command {

    public DrawCommand(JFrame frame) {
		super(frame);
	}
    
    @Override
    public void execute() {
    	
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setBounds(100, 100, 224, 267);
    	frame.setTitle("Sorteio!");
    }
}