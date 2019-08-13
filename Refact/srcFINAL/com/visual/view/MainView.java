package com.visual.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.buttons.main.BTpattern;
import com.config.adm.CalendarMT;
import com.config.adm.Utility;
import com.config.cmd.Cmd;
import com.config.cmd.Singleton;
import com.elements.employee.Funcionario;
import com.elements.schedule.Agenda;
import com.visual.builder.MainViewBuilder;
import com.visual.style.Style;


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
		JLabel LBsorteio = new JLabel("Promover / Sorteio");
		
		
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
		JButton BTpremio = new JButton();
		JButton BTpromote = new JButton();
		  
		try {
			mainScreen.addLBL(contentPane, texto, LBadd, LBremove, LBedit, LBlist, background, LBdata, LBhora, LBcartao, LBtaxa, LBagenda, LBvenda, label_1, LBfolha, LBsemana, LBur, LBsorteio);
			
			BTpattern BTpattern = new BTpattern();
			
			BTpattern.addBT(BTadd, contentPane, 93, 120, "NORMAL", "/com/payroll/icons/add.png", "Adicionar Funcion\u00E1rio");
            BTpattern.addBT(BTedit, contentPane, 451, 120, "NORMAL", "/com/payroll/icons/icons8-editar-v\u00E1rios-80 (1).png" , "Alterar dados");
            BTpattern.addBT(BTremove, contentPane,271, 120, "NORMAL", "/com/payroll/icons/icons8-remover-usu\u00E1rio-masculino-64 (1).png", "");
            BTpattern.addBT(BTatthora, contentPane, 95, 417, "SPECIAL", "/com/payroll/icons/icons8-clock-adicionar-64 (1).png", "");
            BTpattern.addBT(BTponto, contentPane,91, 239, "NORMAL", "/com/payroll/icons/icons8-propriedade-de-tempo-80 (1).png", "");
            BTpattern.addBT(BTtaxa, contentPane, 268, 242, "NORMAL","/com/payroll/icons/icons8-pagamento-online-64.png", "");
            BTpattern.addBT(BTagenda, contentPane, 631, 239, "NORMAL", "/com/payroll/icons/icons8-criar-arquivo-64 (1).png", ""); 
            BTpattern.addBT(BTfolha, contentPane, 701, 386, "NORMAL", "/com/payroll/icons/icons8-transfer\u00EAncia-de-dinheiro-64 (1).png", "");
            BTpattern.addBT(BTattdia, contentPane, 145, 422, "SPECIAL", "/com/payroll/icons/ca28g-fpnyu.png", "");
            BTpattern.addBT(UndoBTN, contentPane, 10, 11,  "SMALL", "/com/payroll/icons/icons8-desfazer-32 (3).png", "");
            BTpattern.addBT(RedoBTN, contentPane, 45, 11, "SMALL", "/com/payroll/icons/icons8-refazer-32.png", "");
            BTpattern.addBT(BTvenda, contentPane, 444, 242, "NORMAL", "/com/payroll/icons/icons8-vender-estoque-64.png", "");
            BTpattern.addBT(BTlist, contentPane, 631, 120,  "NORMAL", "/com/payroll/icons/icons8-lista-de-verifica\u00E7\u00E3o-64.png", "");
            BTpattern.addBT(BTpremio, contentPane, 740, 25,  "SMALL", "/com/payroll/icons/icons8-trevo-32.png", "");
            BTpattern.addBT(BTpromote, contentPane, 700, 25,  "SMALL", "/com/payroll/icons/icons8-mais-2-matem�tica-32.png", "");
		
			Funcionario[] funcionarios = new Funcionario[500];	
			UT.setALL(funcionarios, agenda);
			
			Cmd cmdSingleton = Singleton.getInstance();
			cmdSingleton.saveS(funcionarios);
				
			CalendarMT.clock(LBdata, LBhora, LBsemana, funcionarios);
				
			BTpattern.Command(BTadd, funcionarios, agenda, LBdata, LBhora, "ADD");
			BTpattern.Command(BTedit, funcionarios, agenda, LBdata, LBhora, "EDIT");
			BTpattern.Command(BTremove, funcionarios, agenda, LBdata, LBhora, "RMV");
			BTpattern.Command(BTatthora, funcionarios, agenda, LBdata, LBhora, "ATTH");
			BTpattern.Command(BTtaxa, funcionarios, agenda, LBdata, LBhora, "TAX");
			BTpattern.Command(BTagenda, funcionarios, agenda, LBdata, LBhora, "SCHED");
			BTpattern.Command(BTfolha, funcionarios, agenda, LBdata, LBhora, "PAY"); 
			BTpattern.Command(BTattdia, funcionarios, agenda, LBdata, LBhora, "ATTD");
			BTpattern.Command(UndoBTN, funcionarios, agenda, LBdata, LBhora, "UNDO");
			BTpattern.Command(RedoBTN, funcionarios, agenda, LBdata, LBhora, "REDO");
			BTpattern.Command(BTvenda, funcionarios, agenda, LBdata, LBhora, "SELL");
			BTpattern.Command(BTlist, funcionarios, agenda, LBdata, LBhora, "LIST");
			BTpattern.Command(BTponto, funcionarios, agenda, LBdata, LBhora, "POINT");
			BTpattern.Command(BTpremio, funcionarios, agenda, LBdata, LBhora, "DRAW");
			BTpattern.Command(BTpromote, funcionarios, agenda, LBdata, LBhora, "PROMOTE");
			
			UT.UR(LBur, UndoBTN, RedoBTN);
		}
		catch(Exception e) {
			System.err.print(e);
		}
	
	}
}