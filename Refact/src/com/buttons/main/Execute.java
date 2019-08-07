package com.buttons.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.adm.CalendarMT;
import com.employee.Funcionario;
import com.handler.Handler;
import com.memento.Command;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;
import com.view.EditView;

public class Execute {

	public void execute(String execute, JButton BT, Funcionario[] funcionarios, Agenda[] agenda, JLabel LBdata, JLabel LBhora) {

		Handler Handler = new Handler();

		if(execute.equals("BTadd")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Handler.addViewHandler(funcionarios);
					} catch (Exception e) {
						e.printStackTrace();
					}   
				}
			});
		}else if(execute.equals("BTremove")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new EditView(funcionarios, "remover", agenda).setVisible(true);
				}
			});
		}else if(execute.equals("BTedit")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new EditView(funcionarios, "editar", agenda).setVisible(true);
				}
			});

		}else if(execute.equals("BTlist")) {

			BT.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent arg0) { 
					Handler.ListViewHandler(funcionarios);
				}
			});
		}else if(execute.equals("BTatthora")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Handler.timeViewHandler(LBdata, LBhora, funcionarios);
				}
			});
		}else if(execute.equals("UndoBTN")) {


			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Command.UR_ACTION(funcionarios, "UNDO");
				}
			});

		}
		else if(execute.equals("RedoBTN")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Command.UR_ACTION(funcionarios, "REDO");
				}

			});

		}
		else if(execute.equals("BTponto")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "BPonto", agenda).setVisible(true);
				}
			});
		}	else if(execute.equals("BTtaxa")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "TSindical", agenda).setVisible(true);
				}
			});
		}
		else if(execute.equals("BTvenda")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditView(funcionarios, "Lvenda", agenda).setVisible(true);
				}
			});

		}
		else if(execute.equals("BTagenda")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CriarAgendaView(agenda, funcionarios).setVisible(true);
				}
			});

		}else if(execute.equals("BTfolha")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Handler.folhaViewHandler(funcionarios);

				}
			});
		}
		else if(execute.equals("BTattdia")) {

			BT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CalendarMT.timeChange(funcionarios);
				}
			});
		}


	}

}
