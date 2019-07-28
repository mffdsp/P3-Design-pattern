package com.view;


import com.adm.CalendarMT;
import com.adm.Command;
import com.adm.Utility;
import com.builder.MainViewBuilder;
import com.employee.Funcionario;
import com.schedule.Agenda;
import com.style.Style;

import javax.swing.*;


public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Utility UT = new Utility();
	Agenda agenda[] = new Agenda[500];
	private JPanel contentPane;
	public static int index = 0;
	
	public static void main(String[] args) {
		
	   Style mainStyle = new Style();
	   mainStyle.setStyle();
		
	}
	
	public MainView() throws CloneNotSupportedException {
					
		MainViewBuilder mainScreen = new MainViewBuilder();
		mainScreen.config(this);
		
		contentPane = new JPanel();
		mainScreen.config(contentPane);
		setContentPane(contentPane);

		JLabel texto = new JLabel("Sistema de Folha de pagamento v. Refatorada");
		JLabel LBadd = new JLabel("Adicionar Funcion\u00E1rio");
		JLabel LBremove = new JLabel("Remover Funcion\u00E1rio");
		JLabel LBedit = new JLabel("Alterar Dados");
		JLabel LBlist = new JLabel("Listar Empregados");
		JLabel LBfolha = new JLabel("Rodar Folha ");
		JLabel LBcartao = new JLabel("Cart\u00E3o de Ponto");
		JLabel LBtaxa = new JLabel("Lan\u00E7ar Taxa");
		JLabel LBagenda = new JLabel("Criar Agenda ");
		JLabel LBvenda = new JLabel("Lan\u00E7ar Venda");
		JLabel LBur = new JLabel("New label");
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		
		JLabel LBdata = new JLabel();
		JLabel LBhora = new JLabel();
		JLabel label_1 = new JLabel();
		JLabel LBsemana = new JLabel(CalendarMT.getWeekDay());
		
		
		JButton BTedit = new JButton();
		JButton BTremove = new JButton();
		JButton BTlist = new JButton();
		JButton BTadd = new JButton();
		JButton BTatthora = new JButton();
		JButton UndoBTN = new JButton();
		JButton RedoBTN = new JButton();
		JButton BTponto = new JButton();
		JButton BTtaxa = new JButton();
		JButton BTvenda = new JButton();
		JButton BTagenda = new JButton();
		JButton BTfolha = new JButton();
		JButton BTattdia = new JButton();
		
		try {
			mainScreen.addLBL(contentPane, texto, LBadd, LBremove, LBedit, LBlist, background, LBdata, LBhora, LBcartao, LBtaxa, LBagenda, LBvenda, label_1, LBfolha, LBsemana, LBur);
			mainScreen.addBTN(contentPane, BTedit, BTremove, BTlist, BTadd, BTatthora, UndoBTN, RedoBTN, BTponto, BTtaxa, BTvenda, BTagenda, BTfolha, BTattdia);
				
			Funcionario[] funcionarios = new Funcionario[500];	
			UT.setALL(funcionarios, agenda);
			Command.saveS(funcionarios);
				
			CalendarMT.clock(LBdata, LBhora, LBsemana, funcionarios);
				
			mainScreen.actionBTN(funcionarios, agenda, UT, BTedit, BTremove, BTlist, BTadd, BTatthora, UndoBTN, RedoBTN, BTponto, BTtaxa, BTvenda, BTagenda, BTfolha, BTattdia, LBdata, LBhora);
				
			UT.UR(LBur, UndoBTN, RedoBTN);
		}
		catch(Exception e) {
			System.err.print(e);
		}
	
	}
}

