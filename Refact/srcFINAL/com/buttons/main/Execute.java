package com.buttons.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.config.adm.CalendarMT;
import com.config.cmd.Cmd;
import com.config.cmd.Singleton;
import com.config.handler.Handler;
import com.elements.employee.Funcionario;
import com.elements.schedule.Agenda;
import com.elements.schedule.CriarAgendaView;
import com.visual.view.DrawView;
import com.visual.view.EditView;
import com.visual.view.PromoteView;

public class Execute extends Command{

	public void execute(String execute, JButton BT, Funcionario[] funcionarios, Agenda[] agenda, JLabel LBdata, JLabel LBhora) {
		
		Handler Handler = new Handler();	
		Cmd cmdSingleton = Singleton.getInstance();
		
		if(execute.equals(super.ADD)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Handler.addViewHandler(funcionarios);
					} catch (Exception e) {
						e.printStackTrace();
					}   
				}
			});
		}else if(execute.equals(super.RMV)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new EditView(funcionarios, "remover", agenda).setVisible(true);
				}
			});
				
		}else if(execute.equals(super.EDIT)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new EditView(funcionarios, "editar", agenda).setVisible(true);
				}
			});

		}else if(execute.equals(super.LIST)) {

			BT.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent arg0) { 
					Handler.ListViewHandler(funcionarios);
				}
			});
		}else if(execute.equals(super.ATTH)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Handler.timeViewHandler(LBdata, LBhora, funcionarios);
				}
			});
		}else if(execute.equals(super.UNDO)) {


			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cmdSingleton.UR_ACTION(funcionarios, "UNDO");
				}
			});

		}
		else if(execute.equals(super.REDO)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmdSingleton.UR_ACTION(funcionarios, "REDO");
				}

			});

		}
		else if(execute.equals(super.POINT)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "BPonto", agenda).setVisible(true);
				}
			});
		}	else if(execute.equals(super.TAX)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "TSindical", agenda).setVisible(true);
				}
			});
		}
		else if(execute.equals(super.SELL)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "Lvenda", agenda).setVisible(true);
				}
			});

		}
		else if(execute.equals(super.SCHED)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CriarAgendaView(agenda, funcionarios).setVisible(true);
				}
			});

		}else if(execute.equals(super.PAY)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Handler.folhaViewHandler(funcionarios);

				}
			});
		}
		else if(execute.equals(super.ATTD)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CalendarMT.timeChange(funcionarios);
				}
			});
		}else if(execute.equals(super.DRAW)) {
 
			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new DrawView(funcionarios).setVisible(true);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}else if(execute.equals(super.PROMOTE)) {
 
			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						new PromoteView(funcionarios).setVisible(true);
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			
				}
			});
		}else System.out.println("Comando incorreto!");

	}

}
