# P3-Refact

## Design pattern

- Factory Method <img src="icon/iconS.png" align = "right" >

- Command <img src="icon/iconS.png" align = "right" >

- Memento <img src="icon/iconN.png" align = "right" >


# Factory Design Pattern
Busca criar o objeto sem saber a classe exata em sua chamada de Instancia, por meio de um argumento é definido em uma classe reservada qual instancia aquele objeto receberá.

## Exemplo no código, em com.factoryPattern.FactoryEmployee.java:

```java
package com.factoryPattern;

import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;

public class FactoryEmployee implements EmployeeCreation{

    public Funcionario getEmployee(String type, String name, String adress, String ftype, String payMode, String code) throws Exception {
        if (type.equals("A")) 
            return new Assalariado(name, adress, ftype, payMode, code);
        if (type.equals("C"))
        	return new Comissionado(name, adress, ftype, payMode, code);
        if (type.equals("H"))
        	return new Horista(name, adress, ftype, payMode, code);
        else 
        	throw new IllegalArgumentException("Argumento invalido");
    }	
   
}
```

# Command Design Pattern
Atribui as especificações de um botão, nesse caso, de forma encapsulada, por métodos que realizam cada configuração e/ou ações.

## Exemplo no código, em com.buttons.main.BTpattern.java

```java
package com.buttons.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.employee.Funcionario;
import com.schedule.Agenda;
import com.view.MainView;

public class BTpattern{
		
	public void addBT(JButton BT, JPanel cp, int x, int y, String size, String rc, String msg) throws Exception {
			
		BT.setIcon(new ImageIcon(MainView.class.getResource(rc)));
	    BT.setToolTipText(msg);
	    BT.setContentAreaFilled(false);
	    BT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    
	    int sizeW = 0;
	    int sizeH = 0;
	    
	    if(size.equals("SPECIAL")) {
	    	sizeW = 60;
	    	sizeH = 49;
	    }else if(size.equals("SMALL")) {
			sizeW = 35;
			sizeH = 50;
		}else if(size.equals("NORMAL")) {
			sizeW = 81;
			sizeH = 81;
		}else if(size.equals("LARGE")) {
			sizeW = 100;
			sizeH = 100;
		}else System.err.print("ERRO" + size);
		
		BT.setBounds(x, y, sizeW, sizeH); 
	    styleBT(BT, cp);
	}

	public void styleBT(JButton BT, JPanel cp) throws Exception {
		
        BT.setBackground(Color.WHITE);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        
        cp.add(BT);
        
	}
	
	public void Command(JButton BT, Funcionario[] funcionarios, Agenda[] agendas, JLabel LBdata, JLabel LBhora, String COMMAND) {
		
		new Execute().execute(COMMAND, BT, funcionarios, agendas, LBdata, LBhora);
	}
	
}

```



<!--
## View

- DetailView <img src="icon/iconS.png" align = "right" >

- MainView <img src="icon/iconS.png" align = "right" >

- PayView <img src="icon/iconS.png" align = "right" >

- SellView <img src="icon/iconS.png" align = "right" >

- ListView <img src="icon/iconN.png" align = "right" >

- EditView <img src="icon/iconN.png" align = "right" >

## Employee

- FactoryEmployee - SignUP <img src="icon/iconN.png" align = "right" >

## Schedule

- Schedule - SignUP <img src="icon/iconN.png" align = "right" >
-->
