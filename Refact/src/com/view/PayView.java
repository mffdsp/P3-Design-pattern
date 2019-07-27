package com.view;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
import javax.swing.border.CompoundBorder;

import com.adm.Command;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;

public class PayView extends JFrame {

	private JPanel contentPane;
	int mode = 1;
	
	public PayView(DefaultListModel DLMA, DefaultListModel DLMC,  DefaultListModel DLMH, Funcionario[] func) throws CloneNotSupportedException {
		
		
		Command.saveS(func); 
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Lista de funcionários pagos hoje");
		setBounds(100, 100, 546, 342);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		getContentPane().setBackground(SystemColor.inactiveCaption);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 11, 385, 244);
		contentPane.add(scrollPane);
		

		JList hlist = new JList();
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
		JButton BThorista = new JButton("Horistas");
		BThorista.setForeground(Color.BLACK);
		BThorista.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		BThorista.setIcon(null);
		BThorista.setBackground(Color.WHITE);
		BThorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = 1;
				hlist.setModel(DLMH);
			}
		}); 
		BThorista.setBounds(10, 11, 115, 59);
		contentPane.add(BThorista);
		
		JButton BTcomissionado = new JButton("Comissionados");
		BTcomissionado.setBackground(Color.WHITE);
		BTcomissionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 2;
				hlist.setModel(DLMC);
			}
		});
		BTcomissionado.setBounds(10, 196, 115, 59);
		contentPane.add(BTcomissionado);
		
		JButton BTassalariado = new JButton("Assalariados");
		BTassalariado.setBackground(Color.WHITE);
		BTassalariado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 3;
				hlist.setModel(DLMA);
			}
		});
		BTassalariado.setBorder(null);
		BTassalariado.setBounds(10, 102, 115, 59);
		contentPane.add(BTassalariado);
		
		//Find func
		JButton BTdetalhar = new JButton("Detalhar");
		BTdetalhar.setToolTipText("Clique para detalhar o pagamento");
		BTdetalhar.setBounds(431, 266, 89, 31);
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
					switch (mode){
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
}
