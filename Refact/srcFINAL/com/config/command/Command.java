package com.config.command;

import javax.swing.JFrame;

public abstract class Command {
	
    public JFrame frame;
    
    Command(JFrame frame) {
        this.frame = frame;
    }

    public abstract void execute();
}

