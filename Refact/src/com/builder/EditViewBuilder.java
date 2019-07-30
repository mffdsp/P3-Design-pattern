package com.builder;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.view.EditView;
import com.view.MainView;

public class EditViewBuilder {
	 public void config(EditView frame, String action) {
		 
		 	frame.setResizable(false);
		 	frame.setTitle("Insira o Código de Acesso");
			if(action.equals("TSindical")) {
				frame.setTitle("Insira o código sindical");
			}
			frame.setForeground(Color.WHITE);
			frame.setType(Type.UTILITY);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setBounds(100, 100, 225, 145);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int height = screenSize.height;
			int width = screenSize.width;
			frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
	        
	    } 

	    public void config(JPanel contentPane) {

	    	contentPane.setBackground(SystemColor.menu);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
	    }
	    
}
