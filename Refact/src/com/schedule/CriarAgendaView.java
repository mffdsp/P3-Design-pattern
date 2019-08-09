package com.schedule;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.employee.Funcionario;
import com.factoryPattern.FactorySchedule;
import com.memento.Cmd;
import com.view.MainView;

public class CriarAgendaView extends JFrame {

	private JPanel contentPane;
	
	public CriarAgendaView(Agenda[] agenda, Funcionario[]func){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 277, 226);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		setTitle("Criar Agenda"); 
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		 
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 28, 73, 27);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Semanal", "Mensal"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(106, 33, 112, 20);
		contentPane.add(comboBox);
		
		JLabel lblFrequencia = new JLabel("Frequencia:");
		lblFrequencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrequencia.setBounds(23, 66, 87, 27);
		contentPane.add(lblFrequencia);
		
		JComboBox comboBox_s = new JComboBox();
		comboBox_s.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"})); 
		comboBox_s.setSelectedIndex(0);
		comboBox_s.setBounds(170, 71, 48, 20);
		contentPane.add(comboBox_s);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(CriarAgendaView.class.getResource("/com/payroll/icons/icons8-ok-40.png")));
		button.setToolTipText("Passar hora");
		button.setForeground(SystemColor.inactiveCaption);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(201, 138, 60, 49);
		contentPane.add(button);
		
		JLabel lblDiaDaS = new JLabel("Dia da S.");
		lblDiaDaS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaDaS.setBounds(23, 100, 87, 27);
		contentPane.add(lblDiaDaS);
		
		JComboBox comboBox_ds = new JComboBox();
		comboBox_ds.setModel(new DefaultComboBoxModel(new String[] {"Segunda-Feira", "Terca-Feira", "Quarta-Feira", 
				"Quinta-Feira", "Sexta-Feira"}));
		comboBox_ds.setSelectedIndex(0);
		comboBox_ds.setBounds(106, 104, 112, 20);
		
		JComboBox comboBox_m = new JComboBox();
		
		
		
		contentPane.add(comboBox_s);
		contentPane.add(comboBox_ds); 
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().equals("Semanal") ) {
					
					contentPane.remove(comboBox_m);
					lblDiaDaS.setText("Dia da S.");
					lblFrequencia.setText("Frequencia: ");
					contentPane.add(comboBox_s);
					contentPane.add(comboBox_ds);
					
				}else {
					contentPane.remove(comboBox_s);
					contentPane.remove(comboBox_ds);
					lblDiaDaS.setText("");
					lblFrequencia.setText("Dia: ");
					comboBox_m.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5",
							"6", "7", "8", "9", "10", "11", "12", "13", "14", "15" ,"16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
					comboBox_m.setBounds(170, 71, 48, 20);
					contentPane.add(comboBox_m);
				}
			}
		});		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				FactorySchedule factorySchedule = new FactorySchedule();
				
				String type = comboBox.getSelectedItem().toString();
				String day = null;
				
				int frequency = Integer.parseInt(comboBox_s.getSelectedItem().toString());
				
				if(type.equals("Semanal")) {
					day = comboBox_ds.getSelectedItem().toString();
				}else {
					day = comboBox_m.getSelectedItem().toString();
					frequency = 1;
				}
						
				agenda[Cmd.AgendaIndex] = factorySchedule.getSchedule(type, day, frequency);
				String msg = factorySchedule.toString(agenda[Cmd.AgendaIndex]);
				
				JOptionPane.showMessageDialog(null ,
						"Agenda definida como:\n" + msg , "Sucesso", JOptionPane.INFORMATION_MESSAGE);

				setVisible(false);		
					
				Cmd.AgendaIndex += 1; 
				
			}
		});
		
		
	}
}
