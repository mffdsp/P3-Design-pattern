package com.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LBpattern {
	
	public void addLBL(JLabel LB, JPanel cp, int x, int y, int sizeW, int sizeH) {

		LB.setBounds(x, y, sizeW, sizeH);
		
		styleLBL(LB, cp);
	}
	
	public void styleLBL(JLabel LB, JPanel cp){
		
		LB.setForeground(Color.BLACK);
		LB.setFont(new Font("Tahoma", Font.PLAIN, 17));
        
        cp.add(LB);
        
	}
}
