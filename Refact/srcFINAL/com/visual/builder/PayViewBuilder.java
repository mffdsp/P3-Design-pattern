package com.visual.builder;

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

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import com.elements.employee.Assalariado;
import com.elements.employee.Comissionado;
import com.elements.employee.Funcionario;
import com.elements.employee.Horista;
import com.visual.view.DetailView;
import com.visual.view.MainView;
import com.visual.view.PayView;

public class PayViewBuilder {

	public void config(PayView frame, JPanel contentPane) {
		
		frame.setForeground(Color.WHITE);
		frame.setType(Type.UTILITY);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Lista de funcionários pagos hoje");
		frame.setBounds(100, 100, 546, 342);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setContentPane(contentPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
		
	} 

	public void config(JPanel contentPane) {

		contentPane.setForeground(Color.WHITE);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setLayout(null);
	}
	
	public void addBTN(JPanel contentPane, JButton BThorista, JButton BTcomissionado, JButton BTassalariado, JButton BTdetalhar, DefaultListModel DLMA, DefaultListModel DLMC, DefaultListModel DLMH, JList hlist, Funcionario[] func) {

		BThorista.setForeground(Color.BLACK);
		BThorista.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		BThorista.setIcon(null);
		BThorista.setBackground(Color.WHITE);
		BThorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PayView.mode = 1;
				hlist.setModel(DLMH);
			}
		}); 
		BThorista.setBounds(10, 11, 115, 59);
	
		BTcomissionado.setBackground(Color.WHITE);
		BTcomissionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayView.mode = 2;
				hlist.setModel(DLMC);
			}
		});
		BTcomissionado.setBounds(10, 196, 115, 59);
		
		BTassalariado.setBackground(Color.WHITE);
		BTassalariado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayView.mode = 3;
				hlist.setModel(DLMA);
			}
		});
		BTassalariado.setBorder(null);
		BTassalariado.setBounds(10, 102, 115, 59);
		
		BTdetalhar.setToolTipText("Clique para detalhar o pagamento");
		BTdetalhar.setBounds(431, 266, 89, 31);
		
		
		contentPane.add(BThorista);
		contentPane.add(BTcomissionado);
		contentPane.add(BTassalariado);
		contentPane.add(BTdetalhar);
		
		BTdetalhar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int achou = 0;
				
				try{
					if(hlist.getSelectedIndex() == -1) {
						throw new Exception("Necessário selecionar uma opção");
					}
				}catch(Exception eop) {
					System.err.println(eop);
					return;
				}
				
				for(int i = 0; i < 500; i++) {
					switch (PayView.mode){
					case 1:
						if(func[i] instanceof Horista && !hlist.getSelectedValue().toString().equals("Lista Vazia")  && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 2).setVisible(true);
							}
							achou += 1;
						}
						break;
					case 2:
						if(func[i] instanceof Comissionado && !hlist.getSelectedValue().toString().equals("Lista Vazia")  && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 2).setVisible(true);	
							}
							achou += 1;
						}
						break;
					case 3:
						if(func[i] instanceof Assalariado && !hlist.getSelectedValue().toString().equals("Lista Vazia") && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 2).setVisible(true);
							}
							achou += 1;
						}
						break;
				}	
			}
				
		}});
		
	}
	
	public void addSCL(JPanel contentPane, JScrollPane scrollPane, JList hlist, DefaultListModel DLMA, DefaultListModel DLMC, DefaultListModel DLMH){
		
		scrollPane.setViewportView(hlist);
		
		hlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hlist.setForeground(Color.BLACK);
		hlist.setBackground(Color.WHITE);
		hlist.setBorder(new CompoundBorder());
		hlist.setSelectedIndices(new int[] {2});
		hlist.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length; 
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		hlist.setModel(DLMH);
		
		scrollPane.setBounds(135, 11, 385, 244);
		contentPane.add(scrollPane);
	}

	public void addLBL(JPanel contentPane) {
		
	}
	
}
