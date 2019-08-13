package com.visual.view;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.config.adm.Utility;
import com.config.cmd.Cmd;
import com.config.cmd.Singleton;
import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.payroll.BaterPonto;
import com.elements.payroll.RealEdit;
import com.elements.payroll.TaxaS;
import com.elements.schedule.Agenda;
import com.visual.builder.EditViewBuilder;


public class EditView extends JFrame {

	private static JTextField codeField = new JTextField();
	static Utility UT = new Utility();
	
	public EditView(Funcionario[] func, String action , Agenda[] agenda) {
		
		EditViewBuilder EditViewBuilder = new EditViewBuilder();
		
		EditViewBuilder.config(this, action);
		
		JPanel contentPane = new JPanel();
		EditViewBuilder.config(contentPane); 
		setContentPane(contentPane);
		
		codeField = new JTextField();
		JButton btnIr = new JButton("IR");
		
		codeField.setColumns(10);
		codeField.setBackground(SystemColor.textHighlightText); 
		codeField.setBounds(20, 22, 168, 37);
		
		btnIr.setBounds(141, 66, 50, 34);
		setListener(btnIr, func, action, this, agenda);
		
		contentPane.add(btnIr); 
		contentPane.add(codeField);
	} 
	
	static void setListener(JButton btnIr, Funcionario[] func, String action, EditView frame, Agenda[] agenda){
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = 0;
				boolean notvalid = true;
				try {
					indice = UT.getIndex(codeField.getText());
					notvalid = func[indice] == null || Integer.parseInt(codeField.getText()) < 20190 || !func[indice].isSaved();
				}
				catch(Exception e0) {
					System.err.println(e0);
					JOptionPane.showMessageDialog(null ,
							"Formato inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				setAction(action, notvalid, func, indice,agenda, frame);
			
			}
		});
	}
	
	
	static void setAction(String action, boolean notvalid, Funcionario[] func, int indice, Agenda[] agenda, EditView frame) {
		
		if(action.equals("editar"))
		{
			if(notvalid)
			{
				JOptionPane.showMessageDialog(null ,
						"Código incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else {
				frame.setVisible(false);
				new RealEdit(func, indice, agenda).setVisible(true);
			}
		}else if(action.equals("remover"))  
		{
			if(notvalid)
			{
				JOptionPane.showMessageDialog(null ,
						"Código incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			}	else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				 DetailView DV = new DetailView(func[indice], 1);
				 DV.setVisible(true);
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja remover o funcionario?", "Confirmação", dialogButton);
				if(!(dialogResult == JOptionPane.YES_OPTION) ){
					DV.setVisible(false);
					return;
				}
				DV.setVisible(false);
				func[indice].setSaved(false);
				JOptionPane.showMessageDialog(null ,
				"Funcionário removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
				try {
					Cmd cmdSingleton = Singleton.getInstance();
					cmdSingleton.saveS(func); 
					
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		}else if(action.equals("TSindical"))
		{
			int sindex = UT.findFuncSind(func, codeField.getText());
			if(sindex == -1)
			{
				JOptionPane.showMessageDialog(null ,
						"Código incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else {
				new TaxaS(func, sindex).setVisible(true);
				frame.setVisible(false); 
			}
		}
		if(action.equals("Lvenda"))
		{
			if(notvalid)
			{
				JOptionPane.showMessageDialog(null ,
						"Código incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(func[indice] instanceof Comissionado) {
					new SellView(func, indice).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null ,
							"Funcionário não é do tipo Comissionado\n"
							+ "Para modificar, Dirija-se a edição de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				frame.setVisible(false);
			}
		}
		if(action.equals("BPonto"))
		{
			if(notvalid)
			{
				JOptionPane.showMessageDialog(null ,
						"Código incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else {
				new BaterPonto(func, indice).setVisible(true);
				frame.setVisible(false);
			}
		}
		
	}
}
