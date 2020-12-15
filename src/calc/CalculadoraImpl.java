package calc;

import java.rmi.*;
import java.rmi.server.*;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

	private static final long serialVersionUID = 1L;
	
	public CalculadoraImpl() throws RemoteException{
        super();
    }
    public String calcular(String num1, String num2, String op) {
    	switch (op) {
			case "*":
				return "" + (Double.parseDouble(num1) * Double.parseDouble(num2));
				
			case "/":
				return "" + (Double.parseDouble(num1) / Double.parseDouble(num2));
				
			case "+":
				return "" + (Double.parseDouble(num1) + Double.parseDouble(num2));
				
			case "-":
				return "" + (Double.parseDouble(num1) - Double.parseDouble(num2));
			case "%":  			
	  			return "" + (Double.parseDouble(num1) * (Double.parseDouble(num2)/100.00) )+"%";
	  			
	  		case "#":	  			
	  			return "" + Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
	  			
	  		case "r":  			
	  			return "" + Math.pow(Double.parseDouble(num1), (1/Double.parseDouble(num2)) );
	
			default:				
				return "";					
		}
	    	
    }
}
