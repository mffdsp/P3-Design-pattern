package com.view;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.adm.Command;
import com.builder.PayViewBuilder;
import com.employee.Funcionario;

public class PayView extends JFrame {

	private JPanel contentPane = new JPanel();
	public static int mode = 1;
	
	public PayView(DefaultListModel DLMA, DefaultListModel DLMC,  DefaultListModel DLMH, Funcionario[] func) throws CloneNotSupportedException {
		
		PayViewBuilder PayViewBuilder = new PayViewBuilder();
		PayViewBuilder.config(this, contentPane);
		Command.saveS(func); 
		
		PayViewBuilder.config(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		JList hlist = new JList();
		JButton BThorista = new JButton("Horistas");
		JButton BTcomissionado = new JButton("Comissionados");
		JButton BTassalariado = new JButton("Assalariados");
		JButton BTdetalhar = new JButton("Detalhar");
		 
		PayViewBuilder.addBTN(contentPane, BThorista, BTcomissionado, BTassalariado, BTdetalhar, DLMA, DLMC, DLMH, hlist, func);
		PayViewBuilder.addLBL(contentPane);
		PayViewBuilder.addSCL(contentPane, scrollPane, hlist, DLMA, DLMC, DLMH);
		
	}
}
