package com.view;


import com.adm.CalendarMT;
import com.adm.Command;
import com.adm.Utility;
import com.configuration.ScreenBuilder;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.SignUP;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import java.awt.Dialog.ModalExclusionType;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Utility UT = new Utility();
	Agenda agenda[] = new Agenda[500];
	private JPanel contentPane;
	private JLabel texto;
	private JLabel LBadd;
	private static int index = 0;
	
	public static void main(String[] args) {
	
		//Nimbus set
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
	    //Nimbus set
	    
		try {
			MainView window = new MainView();
			window.setVisible(true);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public MainView() throws CloneNotSupportedException {
					
		ScreenBuilder mainScreen = new ScreenBuilder();
		mainScreen.config(this);
		
		contentPane = new JPanel();
		mainScreen.config(contentPane);
		setContentPane(contentPane);

		JLabel texto = new JLabel("Sistema de Folha de pagamento vers\u00E3o 1.0");
		JLabel LBadd = new JLabel("Adicionar Funcion\u00E1rio");
		JLabel LBremove = new JLabel("Remover Funcion\u00E1rio");
		JLabel LBedit = new JLabel("Alterar Dados");
		JLabel LBlist = new JLabel("Listar Empregados");
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		JLabel LBdata = new JLabel();
		JLabel LBhora = new JLabel();
		JLabel LBcartao = new JLabel("Cart\u00E3o de Ponto");
		JLabel LBtaxa = new JLabel("Lan\u00E7ar Taxa");
		JLabel LBagenda = new JLabel("Criar Agenda ");
		JLabel LBvenda = new JLabel("Lan\u00E7ar Venda");
		JLabel label_1 = new JLabel(" ");
		JLabel LBfolha = new JLabel("Rodar Folha ");
		JLabel LBsemana = new JLabel(CalendarMT.getWeekDay());
		JLabel LBur = new JLabel("New label");
		mainScreen.addLBL(contentPane, texto, LBadd, LBremove, LBedit, LBlist, background, LBdata, LBhora, LBcartao, LBtaxa, LBagenda, LBvenda, label_1, LBfolha, LBsemana, LBur);
		
		JButton BTedit = new JButton("");
		JButton BTremove = new JButton("");
		JButton BTlist = new JButton("");
		JButton BTadd = new JButton("");
		JButton BTatthora = new JButton("");
		JButton UndoBTN = new JButton("");
		JButton RedoBTN = new JButton("");
		JButton BTponto = new JButton("");
		JButton BTtaxa = new JButton("");
		JButton BTvenda = new JButton("");
		JButton BTagenda = new JButton("");
		JButton BTfolha = new JButton("");
		JButton BTattdia = new JButton("");
		mainScreen.addBTN(contentPane, BTedit, BTremove, BTlist, BTadd, BTatthora, UndoBTN, RedoBTN, BTponto, BTtaxa, BTvenda, BTagenda, BTfolha, BTattdia);
		
		Funcionario[] funcionarios = new Funcionario[500];	
		UT.setALL(funcionarios, agenda);
		Command.saveS(funcionarios);
		
		//AddFuncionario();
		BTadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				index = UT.findIndex(funcionarios);
				funcionarios[index] = new Horista(null, null, null, null, null);
				try {
					new SignUP(funcionarios, index).setVisible(true);
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					
					System.err.println("Indice fora dos limites definidos");
				}
				
			}
		});

		//RmvFuncionario();
		BTremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "remover", agenda).setVisible(true);
			}
		});
		
		//editFuncionario();
		BTedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "editar", agenda).setVisible(true);
			}
		});
		
		//listarFuncionario();
		BTlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				DefaultListModel DLMA = new DefaultListModel();
				DefaultListModel DLMC = new DefaultListModel();
				DefaultListModel DLMH = new DefaultListModel();
				try {
					UT.setList(funcionarios, DLMC, DLMA, DLMH);
				}
				catch(NullPointerException e) {
					System.err.println("Exception de ponteiro nulo");
				}
				if(DLMA.getSize() == 0) {
					DLMA.addElement("Lista Vazia");
				}if(DLMH.getSize() == 0) {
					DLMH.addElement("Lista Vazia");
				}if(DLMC.getSize() == 0) {
					DLMC.addElement("Lista Vazia");
				}
				new ListView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
			}
		});
		
	
		BTatthora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.passHour(funcionarios);
				LBdata.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
				+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
				LBhora.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
			}
		});
			
		
		UndoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command.UR_ACTION(funcionarios, "UNDO");
			}
		});
	
		RedoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Command.UR_ACTION(funcionarios, "REDO");
			}

		});
		
		BTponto.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-propriedade-de-tempo-80 (1).png")));
		BTponto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "BPonto", agenda).setVisible(true);
			}
		});
		
		BTtaxa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "TSindical", agenda).setVisible(true);
			}
		});
		
		BTvenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "Lvenda", agenda).setVisible(true);
			}
		});
			
		BTagenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CriarAgendaView(agenda, funcionarios).setVisible(true);
			}
		});
			
		BTfolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CalendarMT.payboo[CalendarMT.DAYSGONE]){
					JOptionPane.showMessageDialog(null ,
							"Folha de pagamento já rodada hoje", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja rodar a folha de pagamento para hoje?", "Confirmação", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					CalendarMT.payboo[CalendarMT.DAYSGONE] =  true;
					DefaultListModel DLMA = new DefaultListModel();
					DefaultListModel DLMC = new DefaultListModel();
					DefaultListModel DLMH = new DefaultListModel();
					try{ 
						UT.payList(funcionarios, DLMC, DLMA, DLMH);
					}
					catch(NullPointerException e2) {
						System.err.println("Exception de ponteiro nulo");
					}
					if(DLMA.getSize() == 0) {
						DLMA.addElement("Lista Vazia");
					}if(DLMH.getSize() == 0) {
						DLMH.addElement("Lista Vazia");
					}if(DLMC.getSize() == 0) {
						DLMC.addElement("Lista Vazia");
					}		
					try {
						new PayView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
					} catch (CloneNotSupportedException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		
		CalendarMT.clock(LBdata, LBhora, LBsemana, funcionarios);
		
		BTattdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.timeChange(funcionarios);
			}
		});
	
		UT.UR(LBur, UndoBTN, RedoBTN);

}
}

