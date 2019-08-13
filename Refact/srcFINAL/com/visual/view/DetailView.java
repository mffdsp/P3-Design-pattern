package com.visual.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.elements.employee.Funcionario;
import com.visual.builder.DetailViewBuilder;


public class DetailView extends JFrame {

	private JPanel contentPane = new JPanel();
	
	public DetailView(Funcionario func, int action) {
		
		DetailViewBuilder DetailViewBuilder = new DetailViewBuilder();
		
		DetailViewBuilder.config(contentPane);
		DetailViewBuilder.config(this, contentPane, action);
		
		JTextField TFname = new JTextField(); 
		JTextField TFcode = new JTextField();
		JTextField TFtype = new JTextField();
		JTextField TFptype = new JTextField(); 
		JTextField TFsalary = new JTextField();
		JTextField TFcustom = new JTextField();
		JTextField TFscode = new JTextField();
		
		JLabel lblNewLabel = new JLabel("Nome :");
		JLabel lblTipo = new JLabel("Code :"); 
		JLabel lblRecebimentoVia = new JLabel("Recebimento via :");
		JLabel lblValor = new JLabel("Valor :");
		JLabel lblTipo_1 = new JLabel("Tipo :");
		JLabel LBscode = new JLabel("SCode:");
		JLabel LBinfo = new JLabel("   Informa\u00E7\u00F5es");
		JLabel LBcustom = new JLabel("Agenda :");
		
		DetailViewBuilder.addLBL(contentPane, lblNewLabel, lblTipo, lblRecebimentoVia, lblValor, lblTipo_1, LBscode, LBinfo, LBcustom);
		DetailViewBuilder.addTF(contentPane, TFname, TFcode, TFtype, TFptype, TFsalary, TFcustom, TFscode, func, action);
		
	}

}
