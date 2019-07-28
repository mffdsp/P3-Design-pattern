package com.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;

import com.adm.Command;
import com.builder.PayViewBuilder;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;

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
