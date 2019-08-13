package com.visual.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.elements.employee.Assalariado;
import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.schedule.Mensal;
import com.elements.schedule.Semanal;
import com.visual.view.DetailView;
import com.visual.view.MainView;

public class DetailViewBuilder {
	
	public void config(DetailView frame, JPanel contentPane, int action) {
		
		frame.setTitle("Detalhes");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		frame.setBounds(100, 100, 300, 361);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setContentPane(contentPane);
		int height = screenSize.height;
		int width = screenSize.width; 
		if(action == 1) {
			frame.setLocation(width/2-frame.getSize().width/2 - 260, height/2-frame.getSize().height/2);
		}else frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		
	} 

	public void config(JPanel contentPane) {
		
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
	}
	public void chooseType(Funcionario func, JTextField TFsalary, int action) {
		
		if(func instanceof Horista && action == 2) {
			TFsalary.setText(Double.toString(((Horista) func).getPsalary()));
		}else if(func instanceof Horista) {
			TFsalary.setText(Double.toString(((Horista) func).getSalarioBase()));
		}else if(func instanceof Comissionado) {
			TFsalary.setText(Double.toString(((Comissionado) func).getPsalary()));
		}else if(func instanceof Assalariado && action == 2) {
			TFsalary.setText(Double.toString(((Assalariado) func).getPsalary()));
		}else TFsalary.setText(Double.toString(func.getSalary()));
		
	}
	public void addTF(JPanel contentPane, JTextField TFname, JTextField TFcode, JTextField TFtype, JTextField TFptype, JTextField TFsalary, JTextField TFcustom, JTextField TFscode, Funcionario func, int action){
		
		TFname.setHorizontalAlignment(SwingConstants.LEFT);
		TFname.setBackground(SystemColor.textHighlightText);
		TFname.setText(func.getName());
		TFname.setEditable(false);
		TFname.setBounds(155, 86, 86, 25);
		TFname.setColumns(10);
		
		TFcode.setText(func.getCode());
		TFcode.setEditable(false);
		TFcode.setColumns(10);
		TFcode.setBackground(Color.WHITE);
		TFcode.setBounds(155, 116, 86, 25);
		
		TFtype.setText(func.getType());
		TFtype.setEditable(false);
		TFtype.setColumns(10);
		TFtype.setBackground(Color.WHITE);
		TFtype.setBounds(155, 146, 86, 25);
		
		TFptype.setText(func.getPayMode());
		TFptype.setEditable(false);
		TFptype.setColumns(10);
		TFptype.setBackground(Color.WHITE);
		TFptype.setBounds(155, 176, 86, 25);
		
		chooseType(func, TFsalary, action);
		
		TFsalary.setEditable(false);
		TFsalary.setColumns(10);
		TFsalary.setBackground(Color.WHITE);
		TFsalary.setBounds(155, 206, 86, 25);
		
		TFcustom.setEditable(false);
		TFcustom.setColumns(10);
		TFcustom.setBackground(Color.WHITE);
		TFcustom.setBounds(155, 236, 86, 25);
		if(func.getAgenda() instanceof Mensal) {
		    TFcustom.setText(((Mensal)func.getAgenda()).toString());
		}else   TFcustom.setText(((Semanal)func.getAgenda()).toString());
	
	    TFscode.setText((String) null);
	    TFscode.setEditable(false);
	    TFscode.setColumns(10);
	    TFscode.setBackground(Color.WHITE);
	    TFscode.setBounds(155, 266, 86, 25);
	    contentPane.add(TFscode);
	    
	    if(func.getUnion().isSindicaty()) {
	    	TFscode.setText(func.getUnion().getSindicatycode());
	    }else TFscode.setText("Não associado"); 
	    
	    contentPane.add(TFsalary);
	    contentPane.add(TFcustom);
	    contentPane.add(TFcode);
		contentPane.add(TFname);
		contentPane.add(TFtype);
		contentPane.add(TFptype);
		
	}
	public void addLBL(JPanel contentPane, JLabel lblNewLabel, JLabel lblTipo, JLabel lblRecebimentoVia, JLabel lblValor, JLabel lblTipo_1, JLabel LBscode, JLabel LBinfo, JLabel LBcustom) {
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(32, 86, 103, 25);
		
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(32, 116, 103, 25);
		
		lblTipo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo_1.setBounds(32, 146, 103, 25);
		
		lblRecebimentoVia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecebimentoVia.setBounds(32, 176, 103, 25);
		
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValor.setBounds(32, 206, 103, 23);
		
		LBinfo.setIcon(new ImageIcon(DetailView.class.getResource("/com/payroll/icons/icons8-painel-de-detalhes-30.png")));
		LBinfo.setBounds(32, 11, 136, 38);
		
		LBcustom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBcustom.setBounds(32, 236, 103, 25);
			
		LBscode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBscode.setBounds(32, 266, 103, 25);
		
		contentPane.add(lblTipo);
		contentPane.add(lblNewLabel);
		contentPane.add(lblRecebimentoVia);
		contentPane.add(lblTipo_1);
		contentPane.add(lblValor);
		contentPane.add(LBinfo);
		contentPane.add(LBcustom);
		contentPane.add(LBscode);
		
	}
}	
