package com.builder;

import com.adm.CalendarMT;
import com.adm.Command;
import com.adm.Utility;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.SignUP;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;
import com.view.EditView;
import com.view.ListView;
import com.view.MainView;
import com.view.PayView;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.view.MainView;

public class MainViewBuilder implements ViewBuilder{
	
	
	public void config(MainView frame) {
		
		frame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame.setType(Type.NORMAL);
		frame.setTitle("FolhaDePagamento");
		frame.setResizable(false);
		frame.setForeground(UIManager.getColor("textHighlight"));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 485, 521);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(813, 517);
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		
	} 

	public void config(JPanel contentPane) {

		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.inactiveCaption);
	} 
	
	public void addBTN(JPanel contentPane, JButton BTedit, JButton BTremove, JButton BTlist, JButton BTadd, JButton BTatthora, JButton UndoBTN, JButton RedoBTN, JButton BTponto, JButton BTtaxa, JButton BTvenda, JButton BTagenda, JButton BTfolha, JButton BTattdia) throws Exception{
		
		BTedit.setContentAreaFilled(false);
		BTedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTedit.setBounds(451, 120, 81, 81);
		BTedit.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-editar-v\u00E1rios-80 (1).png")));
		BTedit.setToolTipText("Alterar Dados");
		BTedit.setForeground(Color.WHITE);
		BTedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTedit.setBackground(Color.WHITE);
		
		BTremove.setContentAreaFilled(false);
		BTremove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTremove.setBounds(271, 120, 81, 81);
		BTremove.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-remover-usu\u00E1rio-masculino-64 (1).png")));
		BTremove.setToolTipText("Remover Funcion\u00E1rio");
		BTremove.setForeground(Color.WHITE);
		BTremove.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTremove.setBackground(Color.WHITE);
		
		BTlist.setContentAreaFilled(false);
		BTlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTlist.setBounds(631, 120, 81, 81);
		BTlist.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-lista-de-verifica\u00E7\u00E3o-64.png")));
		BTlist.setToolTipText("Listar Funcion\u00E1rios");
		BTlist.setForeground(Color.WHITE);
		BTlist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTlist.setBackground(Color.WHITE);
		
		BTadd.setContentAreaFilled(false);
		BTadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTadd.setBounds(93, 120, 81, 81);
		BTadd.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/add.png")));
		BTadd.setToolTipText("Adicionar Funcion\u00E1rio");
		BTadd.setBackground(Color.WHITE);
		BTadd.setForeground(Color.WHITE);
		BTadd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		BTatthora.setToolTipText("Passar hora");
		BTatthora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTatthora.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-clock-adicionar-64 (1).png")));
		BTatthora.setContentAreaFilled(false);
		BTatthora.setBorderPainted(false);
		BTatthora.setBorder(null);
		BTatthora.setForeground(SystemColor.inactiveCaption);
		BTatthora.setBackground(SystemColor.activeCaption);
		BTatthora.setBounds(95, 417, 60, 49);
		
		UndoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UndoBTN.setContentAreaFilled(false);
		UndoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-desfazer-32 (3).png")));
		UndoBTN.setBounds(10, 11, 35, 50);
		
		RedoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RedoBTN.setContentAreaFilled(false);
		RedoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-refazer-32.png")));
		RedoBTN.setBounds(45, 11, 35, 50);	
		
		BTponto.setHorizontalTextPosition(SwingConstants.CENTER);
		BTponto.setHideActionText(true);
		BTponto.setContentAreaFilled(false);
		BTponto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTponto.setToolTipText("Cart\u00E3o de ponto");
		BTponto.setForeground(Color.WHITE);
		BTponto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTponto.setBackground(Color.WHITE);
		BTponto.setBounds(91, 239, 81, 81);
		BTponto.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-propriedade-de-tempo-80 (1).png")));
		
		BTtaxa.setContentAreaFilled(false);
		BTtaxa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTtaxa.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-pagamento-online-64.png")));
		BTtaxa.setToolTipText("Lan\u00E7ar Taxa");
		BTtaxa.setForeground(Color.WHITE);
		BTtaxa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTtaxa.setBackground(Color.WHITE);
		BTtaxa.setBounds(268, 242, 81, 81);
		
		BTvenda.setContentAreaFilled(false);
		BTvenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTvenda.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-vender-estoque-64.png")));
		BTvenda.setToolTipText("Lan\u00E7ar Venda");
		BTvenda.setForeground(Color.WHITE);
		BTvenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTvenda.setBackground(Color.WHITE);
		BTvenda.setBounds(444, 242, 81, 81);		
		
		BTagenda.setVerticalAlignment(SwingConstants.BOTTOM);
		BTagenda.setContentAreaFilled(false);
		BTagenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTagenda.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-criar-arquivo-64 (1).png")));
		BTagenda.setToolTipText("Criar Agenda");
		BTagenda.setForeground(Color.WHITE);
		BTagenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTagenda.setBackground(Color.WHITE);
		BTagenda.setBounds(631, 239, 81, 81);
		
		BTfolha.setContentAreaFilled(false);
		BTfolha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTfolha.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-transfer\u00EAncia-de-dinheiro-64 (1).png")));
		BTfolha.setToolTipText("Listar Funcion\u00E1rios");
		BTfolha.setForeground(new Color(245, 255, 250));
		BTfolha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		BTfolha.setBackground(Color.WHITE);
		BTfolha.setBounds(701, 386, 81, 81);
		
		BTattdia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTattdia.setContentAreaFilled(false);
		BTattdia.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/ca28g-fpnyu.png")));
		BTattdia.setBounds(145, 422, 55, 40);
	
		contentPane.setLayout(null);
		contentPane.add(BTadd);
		contentPane.add(BTremove);
		contentPane.add(BTedit);
		contentPane.add(BTlist);
		contentPane.add(BTatthora);
		contentPane.add(BTponto);
		contentPane.add(BTtaxa);
		contentPane.add(BTvenda);
		contentPane.add(BTagenda);
		contentPane.add(BTfolha);
		contentPane.add(BTattdia);
		contentPane.add(UndoBTN);
		contentPane.add(RedoBTN);
		
	}
		
	
	public void addLBL(JPanel contentPane, JLabel texto, JLabel LBadd, JLabel LBremove, JLabel LBedit, JLabel LBlist, JLabel background, JLabel LBdata, JLabel LBhora, JLabel LBcartao, JLabel LBtaxa, JLabel LBagenda, JLabel LBvenda, JLabel label_1, JLabel LBfolha, JLabel LBsemana, JLabel LBur) throws Exception{
		
		texto.setForeground(SystemColor.controlText);
		texto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		texto.setBounds(625, 11, 180, 14);
		
		LBadd.setBounds(68, 188, 164, 25);
		LBadd.setForeground(SystemColor.activeCaptionText);
		LBadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		LBremove.setForeground(SystemColor.activeCaptionText);
		LBremove.setBounds(242, 188, 147, 25);
		LBremove.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		LBedit.setForeground(SystemColor.activeCaptionText);
		LBedit.setBounds(451, 188, 147, 25);
		LBedit.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBlist.setForeground(SystemColor.activeCaptionText);
		LBlist.setBounds(615, 188, 147, 25);
		LBlist.setFont(new Font("Tahoma", Font.BOLD, 12));

		background.setBounds(11, 1, 0, 0);
		background.setBackground(new Color(0,0,0,80));
		
		LBdata.setForeground(SystemColor.controlText);
		LBdata.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LBdata.setBounds(22, 419, 103, 25);
		
		LBhora.setForeground(SystemColor.controlText);
		LBhora.setFont(new Font("Tahoma", Font.PLAIN, 13));		
		LBhora.setBounds(63, 437, 43, 25);
		LBdata.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
		+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
		LBhora.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
	
		LBcartao.setForeground(SystemColor.activeCaptionText);
		LBcartao.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBcartao.setBounds(80, 315, 147, 25);
		
		LBtaxa.setForeground(SystemColor.activeCaptionText);
		LBtaxa.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBtaxa.setBounds(271, 315, 147, 25);
		
		LBagenda.setForeground(SystemColor.activeCaptionText);
		LBagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBagenda.setBounds(631, 315, 96, 25);
		
		LBvenda.setForeground(SystemColor.activeCaptionText);
		LBvenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBvenda.setBounds(451, 315, 147, 25);
		
		label_1.setBounds(10, 135, 46, 14);
		
		LBfolha.setForeground(Color.BLACK);
		LBfolha.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBfolha.setBounds(705, 448, 96, 25);
		
		LBsemana.setForeground(Color.BLACK);
		LBsemana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBsemana.setBounds(22, 453, 96, 25);
		
		LBur.setFont(new Font("Tahoma", Font.BOLD, 13));
		LBur.setForeground(new Color(30, 144, 255));
		LBur.setBounds(15, 46, 84, 30);
		
		contentPane.setLayout(null);
		contentPane.add(LBadd);
		contentPane.add(LBremove);
		contentPane.add(LBlist);
		contentPane.add(LBedit);
		contentPane.add(texto);
		contentPane.add(LBhora);
		contentPane.add(LBdata);
		contentPane.add(LBcartao);
		contentPane.add(LBagenda);
		contentPane.add(LBvenda);
		contentPane.add(label_1);
		contentPane.add(LBfolha);
		contentPane.add(LBsemana);
		contentPane.add(LBur);
		contentPane.add(LBtaxa);
	
	}
	
	public void actionBTN(Funcionario[] funcionarios, Agenda[] agenda, Utility UT, JButton BTedit, JButton BTremove, JButton BTlist, JButton BTadd, JButton BTatthora, JButton UndoBTN, JButton RedoBTN, JButton BTponto, JButton BTtaxa, JButton BTvenda, JButton BTagenda, JButton BTfolha, JButton BTattdia, JLabel LBdata, JLabel LBhora)throws Exception{
		
		BTadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainView.index = UT.findIndex(funcionarios);
				funcionarios[MainView.index] = new Horista(null, null, null, null, null);
				try {
					new SignUP(funcionarios, MainView.index).setVisible(true);
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					
					System.err.println("Indice fora dos limites definidos");
				}
				
			}
		});

		BTremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "remover", agenda).setVisible(true);
			}
		});
		
		BTedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "editar", agenda).setVisible(true);
			}
		});
		
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
		
		BTattdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.timeChange(funcionarios);
			}
		});
		
	}

}