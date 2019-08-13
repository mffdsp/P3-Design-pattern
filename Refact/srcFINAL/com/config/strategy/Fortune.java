package com.config.strategy;

public class Fortune extends StrategySolution {
	
    private int state = 1;

    protected void start() {
        System.out.print("Start");
    }

    protected void stop() {
        System.out.println("Stop");
    }

    protected boolean nextTry() {
        System.out.print("Tentativa -> " + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.print("Sucesso!\nTentativas -> " + "state" + "  ");
        return (state <= 5000);
    }
}