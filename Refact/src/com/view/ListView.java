package com.view;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;

import com.builder.ListViewBuilder;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;

public class ListView extends JFrame {

	private static final long serialVersionUID = 1L;
	int mode = 1;
	
	public ListView(DefaultListModel<?> DLMA, DefaultListModel<?> DLMC,  DefaultListModel<?> DLMH, Funcionario[] func) {
		
		ListViewBuilder ListViewBuilder = new ListViewBuilder();
		
		ListViewBuilder.config(this);
		
		JPanel contentPane = new JPanel(); 
		ListViewBuilder.config(contentPane);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		JList hlist = new JList();
		JButton BThoristas = new JButton("Horistas");
		JButton BTcomissionados = new JButton("Comissionados");
		JButton BTassalariado = new JButton("Assalariados");
		JButton BTdetalhar = new JButton("Detalhar");
		
		scrollPane.setBounds(135, 11, 385, 244);
		 
		scrollPane.setViewportView(hlist);
		
		hlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hlist.setForeground(Color.BLACK);
		hlist.setBackground(Color.WHITE); 
		hlist.setBorder(new CompoundBorder());
		hlist.setSelectedIndices(new int[] {2});
		hlist.setModel(DLMH);
		
		BThoristas.setForeground(Color.BLACK);
		BThoristas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		BThoristas.setIcon(null);
		BThoristas.setBackground(Color.WHITE);
		BThoristas.setBounds(10, 11, 115, 59);
		BThoristas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = 1;
				hlist.setModel(DLMH);
			}
		});
		
		BTcomissionados.setBackground(Color.WHITE);
		BTcomissionados.setBounds(10, 196, 115, 59);
		BTcomissionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 2;
				hlist.setModel(DLMC);
			}
		});
		
		BTassalariado.setBackground(Color.WHITE);
		BTassalariado.setBorder(null);
		BTassalariado.setBounds(10, 102, 115, 59);
		BTassalariado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 3;
				hlist.setModel(DLMA);
			}
		});
		
		BTdetalhar.setToolTipText("Clique para detalhar o funcionario");
		BTdetalhar.setBounds(431, 266, 89, 31);
		setListener(BTdetalhar, func, hlist);
		
		contentPane.add(BTcomissionados);
		contentPane.add(BThoristas);
		contentPane.add(BTassalariado);
		contentPane.add(BTdetalhar);
		contentPane.add(scrollPane);
		
	}
	
	public void setListener(JButton BTdetalhar, Funcionario[] func, JList hlist) {
		
		BTdetalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					if(hlist.getSelectedIndex() == -1) {
						throw new Exception("Necessário selecionar uma opção");
					}
				}catch(Exception eop) {
					System.err.println(eop);
					return;
				}
				int achou = 0;
				for(int i = 0; i < 500; i++) {
					switch (mode){
					case 1:
						if(func[i] instanceof Horista && !hlist.getSelectedValue().toString().equals("Lista Vazia")  && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 1).setVisible(true);
							}
							achou += 1;
						}
						break;
					case 2:
						if(func[i] instanceof Comissionado && !hlist.getSelectedValue().toString().equals("Lista Vazia")  && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 1).setVisible(true);	
							}
							achou += 1;
						}
						break;
					case 3:
						if(func[i] instanceof Assalariado && !hlist.getSelectedValue().toString().equals("Lista Vazia") && func[i].isSaved()) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i], 1).setVisible(true);
							}
							achou += 1;
						}
						break;
				}	
			}
		}});
	}
}
