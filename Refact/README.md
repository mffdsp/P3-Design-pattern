
# P3-Refact

## Links
[Verificar código completo](https://github.com/mffdsp/P3-Refact/tree/master/Refact/srcFINAL/com)

[Download .jar](https://github.com/mffdsp/P3-Refact/raw/master/Refact/refactory.jar)
```
Funcionalidades Adicionadas:

	- Realizar Sorteio promocional entre membros do sindicato.
	
	- Funcionários possuem níveis de cargo, possibilitando bonus em salário.
```
## Design pattern

- Factory Method <img src="icon/iconS.png" align = "right" >

- Command <img src="icon/iconS.png" align = "right" >

- Template <img src="icon/iconS.png" align = "right" >

- State <img src="icon/iconS.png" align = "right" >

- Builder <img src="icon/iconS.png" align = "right" >

- Prototype <img src="icon/iconS.png" align = "right" >

- Singleton <img src="icon/iconS.png" align = "right" >

- Observer <img src="icon/iconS.png" align = "right" >

- Memento <img src="icon/iconS.png" align = "right" >
---

## Resumo
| Tipo  | Exemplo de aplicação |
| ------------- | ------------- |
|Factory |  [com.factoryPattern.FactoryEmployee.java](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/factoryPattern/FactoryEmployee.java) |
|Template | [com.draw.Draw](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/draw/Draw.java) |
|State | [com.state.State](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/state/State.java)|
|Observer |[com.view.DrawView.java](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/view/DrawView.java) |
|Command |[com.command.DrawCommand](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/command/DrawCommand.java) |
|Prototype | [com.cmd.Cmd](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/cmd/Cmd.java) |
|Singleton | [com.cmd.Singleton](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/cmd/Singleton.java) |
|Builder | [com.style.Style](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/style/Style.java) |
|Memento | [com.memento.Memento](https://github.com/mffdsp/P3-Refact/blob/master/Refact/srcFINAL/com/memento/Memento.java) |
---
# -Template Design Pattern-

Realiza ações de forma encadeada, em sequencia, as subclasses decidem como implementar os passos de um algoritimo;

## Definido em [com.draw.Draw](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/draw/Draw.java) 
```java
package com.draw;

import com.employee.Funcionario;

public abstract class Draw {

	public final void sorteioDiario(Funcionario[] f) {
		selecionarFuncionarios(f);
		sortearFuncionario(); 
		addPremio(f);
	}

	abstract void selecionarFuncionarios(Funcionario[] f);
	abstract void sortearFuncionario();
	abstract void addPremio(Funcionario[] f);

}
```
## Implementado em [com.draw.Fortune](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/draw/Fortune.java)
```java
public class Fortune extends Draw {
	void selecionarFuncionarios(Funcionario[] f) {
		 //CODE
	}
	void sortearFuncionario() {
		//CODE
	}
	void addPremio(Funcionario[] f) {
		//CODE
	}
}
```
## Chamado em [com.view.DrawView](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/view/DrawView.java)
```java
public class DrawView extends JFrame {

	draw.sorteioDiario(f);	
}
```
---

# -State Design Pattern-

Permite que um objeto altere seu comportamento quando seu estado interno é alterado, de forma encapsulada.

## Definido em [com.state.State](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/state/State.java)
```java
package com.state;

import com.employee.Funcionario;

public interface State {
	void promote(Funcionario f);

}

```
## Classes concretas: [com.state.Nivel_1/Nivel_2/Nivel_3/Nivel_4/Senior](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/state/Nivel_1.java)

```java
package com.state;

import com.employee.Funcionario;

public class Nivel_1 implements State{

	public String toString() {
		return "Nivel 1";
	}
	
	public void promote(Funcionario f) {
		
		f.setSalary(f.getSalary()*1.0);
		f.setState( new Nivel_2() );
		
	}

}

```
## Chamado em [com.view.PromoteView](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/view/PromoteView.java)
```java
btnNewButton.addActionListener(new ActionListener() {
	f[indice].promote();
}
```
---
# - Observer Design Patter-

Defina uma dependência entre objetos para que, quando um objeto mudar de estado, todos os seus dependentes sejam notificados e atualizados automaticamente.
Neste caso os Objetos JProgressBar e a JFrame, dependem exclusivamente do estado de JButton, caso ocorra a chamada do metodo ActionListener(), todos são atualizados automaticamente.

Em [com.view.DrawView.java](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/view/DrawView.java)

```java

public class DrawView extends JFrame {

	private JPanel contentPane;
	Draw draw = new Fortune();
	Utility UT = new Utility();
	
	public DrawView(Funcionario[] f) throws InterruptedException { 
	
		JButton btnSorteio = new JButton("GO");
		JTextPane txtpnRegrasFuncionario = new JTextPane();
		JProgressBar progressBar = new JProgressBar();
		
		//A implementação do Metodo em Jbutton gera uma alteração em JProgressBar e em JFrame
		btnSorteio.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				UT.progressBar(progressBar);	//JProgressBar
				draw.sorteioDiario(f);		//Chamada por Template
				setVisible(false);		//JFrame
			}
		});
		
		contentPane.add(progressBar);
		contentPane.add(btnSorteio);
		contentPane.add(txtpnRegrasFuncionario);
	}
}


```

# -Command Design Pattern-
Encapsula uma solicitação como um objeto;
Nesse caso utilizei no desenho de uma Janela.

## Em [com.command.DrawCommand](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/command/DrawCommand.java)
```java
package command;

import javax.swing.JFrame;

public abstract class Command {
	
    public JFrame frame;
    
    Command(JFrame frame) {
        this.frame = frame;
    }

    public abstract void execute();
}

```

```java
package command;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DrawCommand extends Command {

    public DrawCommand(JFrame frame) {
		super(frame);
	}
    
    @Override
    public void execute() {
    	
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setBounds(100, 100, 224, 267);
    	frame.setTitle("Sorteio!");
    }
}

```

Outra aplicação de forma diferente, para ações de cada JButton.

```java
public abstract class Command {
	
	public String ADD = "ADD";
	public String EDIT = "EDIT";
	public String RMV = "RMV";
	public String ATTH = "ATTH";
	public String TAX = "TAX";
	public String SCHED = "SCHED";
	public String PAY = "PAY";
	public String ATTD = "ATTD";
	public String UNDO = "UNDO";
	public String REDO = "REDO";
	public String SELL = "SELL";
	public String LIST = "LIST";
	public String POINT = "POINT";
}

```

## Aplicado no código, em MainView, para todo BTN.

```java
public MainView() throws CloneNotSupportedException {

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
}
```

# -Factory Design Pattern-
Busca criar o objeto sem saber a classe exata em sua chamada de Instancia, por meio de um argumento é definido em uma classe reservada qual instancia aquele objeto receberá.

## Exemplo no código, em [com.factoryPattern.FactoryEmployee.java](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/factoryPattern/FactoryEmployee.java)

```java
package com.factoryPattern;

import com.employee.Funcionario;

public interface EmployeeCreation {
	
	 public Funcionario getEmployee(String type, String name, String adress, String ftype, String payMode, String code);
}

```
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

## Exemplo no código, em [com.factoryPattern.ScheduleCreation](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/factoryPattern/ScheduleCreation.java)

```java
package com.factoryPattern;

import com.schedule.Agenda;

public interface ScheduleCreation {
	
	  public Agenda getSchedule(String type, String day, int frequency);
	 
}

```
```java
package com.factoryPattern;

import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;

public class FactorySchedule implements ScheduleCreation{

    @Override
    public Agenda getSchedule(String type, String day, int frequency) {
		
        if (type.equals("Mensal")) 
            return new Mensal(day, frequency);
        if (type.equals("Semanal"))
            return new Semanal(day, frequency);
        else 
            System.err.println("Argumento invalido");
            return null;
    }
}
```

# -Prototype Design Pattern-
Criaa, usando uma instância prototípica, novos objetos copiando esse protótipo

## Exemplo no código, na implementação de UNDO/REDO;

```java
public class Assalariado extends Signature implements Cloneable{
	//Classe a ser prototipada implementa a interface Cloneable
	 @Override
	 public Assalariado clone() throws CloneNotSupportedException {
	     return (Assalariado) super.clone();
	 }
	 
}

```
## Clonado em [com.cmd.Cmd](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/cmd/Cmd.java)
```java
public class Cmd implements CommandInterface{

	void saveS(Funcionario[] func) throws CloneNotSupportedException {
    	for(int i = 0; i < 500; i++) {
		
		SS[i][SSindex].funcionariosSAVE = new Horista(null, null, null, null, null);
		SS[i][SSindex].funcionariosSAVE = func[i]).clone(); //Chamada de prototipo.
	}

    }
	 
}

```
# -Singleton Design Pattern-
Garante que exista apenas uma instancia de um objeto em todo o código, nesse caso o objeto cmd, que cuida do UNDO/REDO.

Em [com.cmd.Singleton](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/cmd/Singleton.java)
```java
package com.cmd;

public final class Singleton{
	
	private static Cmd cmd;
	
	public static Cmd getInstance() {
		  
	        if (cmd == null) {
	            cmd = new Cmd();
	        }
	        return cmd;
	 }
}
	
```

Exemplo de utilização em [com.view.MainView](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/view/MainView.java)

```java
public MainView() throws CloneNotSupportedException{

	Cmd cmdSingleton = Singleton.getInstance();
	//Utilizando Singleton.getinstance(), a instancia  de Cmd retornada é a mesma utilizada em outras partes do código.
	cmdSingleton.saveS(funcionarios);
}


```

# -Builder Design Pattern-
Separa a construção de um objeto complexo de sua representação, movendo a responsabilidade de Criação para outras classes.

## Exemplo no código, na criação de View, modificando seu Estilo fora da Classe principal.

[com.style.Style](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/style/Style.java) -> Define Estilo de Janela e Fontes.

[com.builder.MainViewBuilder](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/builder/MainViewBuilder.java) -> Define Configuração de Frame, Panel e Label.

```java
package com.style;

public interface StyleInterface {
	
	void setStyle();

}
```

```java
public class Style implements StyleInterface{

	public void setStyle() {
	    try {
		   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	      	 	  if ("Nimbus".equals(info.getName())) {
	                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
			  break;
	            }
	      	 }
	    } catch (Exception ex) {
	    	   System.err.println(ex); 
	    }	
	    init();
	}
	
	public void setGround(String type, JButton BTatthora) {
		
		if(type.equals("CAPTION")) {
			
			BTatthora.setForeground(SystemColor.inactiveCaption);
			BTatthora.setBackground(SystemColor.activeCaption);
			
		}else System.err.print("type_error");
	}
}
````
Além disso, como o código é baseado em JFrame, é obrigatório que se use o Builder na criação de uma janela.
Por exemplo em: 
[com.builder.TaxaViewBuilder](https://github.com/mffdsp/P3-Refact/blob/master/Refact/src/com/builder/TaxaViewBuilder.java)

```java
public class TaxaViewBuilder {
	
	public void config(TaxaS frame) {
        
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 225, 205);  //Constroi limites
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png"))); //Constroi icone
		frame.setTitle("Registrar Taxa"); //Constroi icone
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2); //Constroi Localização Inicial
        
    } 

	public void config(JPanel contentPane) {

		contentPane.setBackground(SystemColor.menu); //Modifica o BG
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Modifica as bordas
		
		contentPane.setLayout(null);
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
