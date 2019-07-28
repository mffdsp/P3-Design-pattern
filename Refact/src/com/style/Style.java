package com.style;

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
}