package com.visual.builder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.visual.view.ListView;
import com.visual.view.MainView;

public class ListViewBuilder {
	
	public void config(ListView frame) {
        
		frame.setForeground(Color.WHITE); 
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Lista de funcionários adicionados ao sistema");
		frame.setBounds(100, 100, 545, 335);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
        
    } 

	public void config(JPanel contentPane) {

		contentPane.setForeground(Color.WHITE);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.inactiveCaption);
	
    }

}