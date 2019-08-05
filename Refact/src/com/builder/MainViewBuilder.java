package com.builder;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.adm.CalendarMT;
import com.adm.Utility;
import com.employee.Funcionario;
import com.handler.Handler;
import com.memento.Command;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;
import com.view.EditView;
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
        
        Handler Handler = new Handler();
        
        BTadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
					Handler.addViewHandler(funcionarios);
				} catch (Exception e) {
					e.printStackTrace();
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
                Handler.ListViewHandler(funcionarios);
            }
        });
        
        BTatthora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Handler.timeViewHandler(LBdata, LBhora, funcionarios);
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
                Handler.folhaViewHandler(funcionarios);
                
            }
        });
        
        BTattdia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CalendarMT.timeChange(funcionarios);
            }
        });
        
    }

}