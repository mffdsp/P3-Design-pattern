package com.visual.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.elements.payroll.RealEdit;
import com.elements.schedule.Agenda;
import com.visual.view.MainView;

public class RealEditBuilder {
	
	public void config(RealEdit frame, JPanel contentPane) {
		
		frame.setTitle("Editar Informações");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		frame.setForeground(Color.WHITE);
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setContentPane(contentPane);
		frame.setSize(612, 532);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		
		
	} 

	public void config(JPanel contentPane) {

		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setFocusCycleRoot(true);
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBounds(0, 0, 604, 506); 
	}
	
	public void addTF(JPanel contentPane, JTextField TFvalor, JTextField TFadress, JTextField TFname, JTextField TFcomi, JTextField TFscode, JButton TFcustom, Funcionario func) {
		
		TFvalor.setHorizontalAlignment(SwingConstants.RIGHT);
		TFvalor.setColumns(10);
		
		if(func instanceof Horista)
		{
			TFvalor.setText(Double.toString(((Horista)func).getSalarioBase()));
		}else TFvalor.setText(Double.toString(func.getSalary()));	
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(77, 384, 57, 24);
		
		TFadress.setText(func.getAdress());
		TFadress.setColumns(10);
		TFadress.setBackground(SystemColor.textHighlightText);
		TFadress.setBounds(142, 161, 285, 24);
		
		TFname.setText(func.getName());
		TFname.setForeground(Color.BLACK);
		TFname.setColumns(10);
		TFname.setBackground(SystemColor.textHighlightText);
		TFname.setBounds(142, 126, 285, 24);
		
		TFcomi.setHorizontalAlignment(SwingConstants.RIGHT);
		TFcomi.setColumns(10);
		TFcomi.setBackground(SystemColor.textHighlightText);
		TFcomi.setBounds(200, 416, 57, 24);
		
		TFscode.setHorizontalAlignment(SwingConstants.RIGHT);
		TFscode.setColumns(10);
		TFscode.setBackground(Color.WHITE);
		TFscode.setBounds(369, 67, 57, 24);
		
		TFcustom.setToolTipText("Clique para mostrar as agendas");
		TFcustom.setBounds(449, 94, 132, 23);
		
		contentPane.add(TFadress);
		contentPane.add(TFname);
		contentPane.add(TFcomi);
		contentPane.add(TFscode);
		contentPane.add(TFvalor);
		contentPane.add(TFcustom);
	}
	public void setAction(JButton TFcustom, Agenda[] agenda, JList list, JScrollPane scrollPane_1, JComboBox CBtipo , JLabel LBcomi, JLabel LBpcomi, JTextField TFcomi, JLabel LBrs, JPanel contentPane) {
		
		TFcustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RealEdit.acc == 1 && agenda[0].isSaved()) 
				{
					RealEdit.acc = 0; list.setVisible(true);			
					DefaultListModel DLMA = new DefaultListModel();
					for(int i = 0; i < 50; i++) { 
						if(agenda[i].isSaved()) {		
							DLMA.addElement(agenda[i]);
						}
					}
					scrollPane_1.setBounds(448, 130, 132, 176);
					list.setForeground(Color.BLACK);
					list.setFont(new Font("Tahoma", Font.PLAIN, 14));
					list.setBorder(new CompoundBorder());
					list.setBackground(Color.WHITE);
					list.setBounds(448, 130, 132, 176);
					contentPane.add(list); 
					contentPane.add(scrollPane_1);
					list.setModel(DLMA);
					list.setSelectedIndex(0);
					scrollPane_1.setViewportView(list);
					list.setVisible(true);
					scrollPane_1.setVisible(true);
					RealEdit.custom = true;
				}
				else if(RealEdit.acc == 0) {
					RealEdit.acc = 1;
					RealEdit.custom = false;
					list.setVisible(false);
					scrollPane_1.setVisible(false);
					contentPane.remove(list);
					
				}
				if(!agenda[0].isSaved()) {
					JOptionPane.showMessageDialog(null ,
							"Ainda não há agendas criadas!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		CBtipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CBtipo.getSelectedItem().toString().equals("Comissionado")){
					LBcomi.setVisible(true);
					LBpcomi.setVisible(true);
					TFcomi.setVisible(true);
				}else {
					LBcomi.setVisible(false);
					LBpcomi.setVisible(false);
					TFcomi.setVisible(false);
				}
				if(CBtipo.getSelectedItem().toString().equals("Horis"
						+ "ta")){
					LBrs.setText("R$/hora");
				}else {
					LBrs.setText("R$");
				}
			}
		});
		
	}
	

}
