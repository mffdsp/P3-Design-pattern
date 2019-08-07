# P3-Refact

## Design pattern

- Factory Method <img src="icon/iconS.png" align = "right" >

- Command <img src="icon/iconS.png" align = "right" >

- Memento <img src="icon/iconN.png" align = "right" >


# Factory Method -> ## Busca criar o objeto sem saber a classe exata em sua chamada de Instancia, por meio de um argumento é definido em uma classe reservada qual instancia aquele objeto receberá.

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
```java





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
