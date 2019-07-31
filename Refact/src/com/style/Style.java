package com.style;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import com.view.MainView;

public class Style{
	
	public void setStyle() {
		
		try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (Exception ex) {
	       System.err.println(ex);
	    }
	    
		try {
			MainView window = new MainView();
			window.setVisible(true);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void setGround(String type, JButton BTfolha, JButton BTagenda, JButton BTvenda, JButton BTtaxa, JButton BTponto, JButton BTedit, JButton BTremove, JButton BTadd, JButton BTlist) {
		if(type.equals("WHITE")) {
			
	        BTremove.setBackground(Color.WHITE);
	        BTedit.setBackground(Color.WHITE);
	        BTvenda.setBackground(Color.WHITE);
	        BTlist.setBackground(Color.WHITE);
	        BTtaxa.setBackground(Color.WHITE);
	        BTagenda.setBackground(Color.WHITE); 
	        BTfolha.setBackground(Color.WHITE);
	        
	        BTlist.setForeground(Color.WHITE);   
	        BTedit.setForeground(Color.WHITE);
	        BTremove.setForeground(Color.WHITE);
	       
	        BTponto.setForeground(Color.WHITE);   
	        BTtaxa.setForeground(Color.WHITE);         
	        BTvenda.setForeground(Color.WHITE);
	        BTagenda.setForeground(Color.WHITE);
	        BTfolha.setForeground(new Color(245, 255, 250));
	        
	        BTlist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	       
	        BTponto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        BTtaxa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        BTvenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));     
	        BTagenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        BTfolha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
	        BTedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	        BTremove.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	       
		}else System.err.print("erro");
	}
	
	public void setGround(String type, JButton BTatthora) {
		if(type.equals("CAPTION")) {
			
			BTatthora.setForeground(SystemColor.inactiveCaption);
			BTatthora.setBackground(SystemColor.activeCaption);
			
		}else System.err.print("erro");
	}
}