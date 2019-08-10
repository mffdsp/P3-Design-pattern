package com.buttons.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.employee.Funcionario;
import com.schedule.Agenda;
import com.view.MainView;

public class BTpattern{
		
	public void addBT(JButton BT, JPanel cp, int x, int y, String size, String rc, String msg) throws Exception {
			
		BT.setIcon(new ImageIcon(MainView.class.getResource(rc)));
	    BT.setToolTipText(msg);
	    BT.setContentAreaFilled(false);
	    BT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    int sizeW = 0;
	    int sizeH = 0;
	    
	    if(size.equals("SPECIAL")) {
	    	sizeW = 60;
	    	sizeH = 49;
	    }else if(size.equals("SMALL")) {
			sizeW = 35; 
			sizeH = 50;
		}else if(size.equals("NORMAL")) {
			sizeW = 81;
			sizeH = 81;
		}else if(size.equals("LARGE")) {
			sizeW = 100;
			sizeH = 100;
		}else System.err.print("ERRO" + size);
		
		BT.setBounds(x, y, sizeW, sizeH); 
	    styleBT(BT, cp);
	}

	public void styleBT(JButton BT, JPanel cp) throws Exception {
		
        BT.setBackground(Color.WHITE);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        
        cp.add(BT);
        
	}
	
	public void Command(JButton BT, Funcionario[] funcionarios, Agenda[] agendas, JLabel LBdata, JLabel LBhora, String COMMAND) {
		
		new Execute().execute(COMMAND, BT, funcionarios, agendas, LBdata, LBhora);
	}
	
}
