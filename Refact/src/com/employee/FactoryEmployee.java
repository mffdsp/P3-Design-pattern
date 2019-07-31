package com.employee;

public class FactoryEmployee {

    public Funcionario getEmployee(String type, String name, String adress, String ftype, String payMode, String code) throws Exception {
        if (type.equals("A"))
            return new Assalariado(name, adress, ftype, payMode, code);
        if (type.equals("C"))
        	return new Comissionado(name, adress, ftype, payMode, code);
        if (type.equals("H"))
        	return new Horista(name, adress, ftype, payMode, code);
        else 
        	return null;  
    }
   
}
