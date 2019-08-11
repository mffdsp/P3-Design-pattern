package com.builder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.adm.Utility;
import com.cmd.Cmd;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.view.DetailView;
import com.view.MainView;
import com.view.PayView;
import com.view.SellView;

public class SellViewBuilder {
	
	public void config(SellView frame, JPanel contentPane) {
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 225, 205);
		frame.setTitle("Lançar Venda"); 
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		frame.setContentPane(contentPane);
		
	} 

	public void config(JPanel contentPane) { 
		
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null); 
	}
	
	public void addBTN(JPanel contentPane, JButton BTsave, JEditorPane TFobs, JTextField TFvalor, Funcionario[] func, int index, SellView frame) {
		Utility UT = new Utility();
		
		TFobs.setBackground(SystemColor.textHighlightText);
		TFobs.setText("Caso tenha observaçoes sobre a venda, insira aqui");
		TFobs.setBounds(0, 87, 141, 79);
		
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(113, 24, 86, 29);
		TFvalor.setColumns(10);
		
		contentPane.add(BTsave);
		contentPane.add(TFobs);
		contentPane.add(TFvalor);
		
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					double value = Double.parseDouble(TFvalor.getText());
					double addValue = value * ((Comissionado)func[index]).getPVenda()/100;
					
					((Comissionado)func[index]).addBonussalary(addValue);
					((Comissionado)func[index]).setPsalary(func[index].getSalary() + ((Comissionado)func[index]).getBonussalary());
					
					JOptionPane.showMessageDialog(null ,
							"Venda associada com sucesso à:\n"
							+ func[index].getName() + "\nTaxa de:" + ((Comissionado)func[index]).getPVenda() 
							+ "%\nValor adicionado: " +
							addValue + "RS", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					
					Cmd.saveS(func);
					frame.setVisible(false);
				} catch(Exception ex0) {
					UT.ERRO();
					System.err.print(ex0); 
					return;
				}
			}
		});
		BTsave.setBounds(140, 87, 69, 79);
		
	}
	
	public void addLBL(JPanel contentPane, JLabel LBtaxa) {
		
		LBtaxa.setHorizontalAlignment(SwingConstants.LEFT);
		LBtaxa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LBtaxa.setBounds(10, 31, 93, 14);
		
		contentPane.add(LBtaxa); 
		
	}
	
}
