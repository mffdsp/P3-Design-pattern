package com.buttons.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.adm.CalendarMT;
import com.cmd.Cmd;
import com.employee.Funcionario;
import com.handler.Handler;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;
import com.view.DrawView;
import com.view.EditView;
import com.view.PromoteView;

public class Execute extends Command{

	public void execute(String execute, JButton BT, Funcionario[] funcionarios, Agenda[] agenda, JLabel LBdata, JLabel LBhora) {
		
		Handler Handler = new Handler();	

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
					Cmd.UR_ACTION(funcionarios, "UNDO");
				}
			});

		}
		else if(execute.equals(super.REDO)) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cmd.UR_ACTION(funcionarios, "REDO");
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
