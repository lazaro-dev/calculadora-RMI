package calc;

import java.rmi.*;
import java.rmi.server.*;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

	private static final long serialVersionUID = 1L;
	
	public CalculadoraImpl() throws RemoteException{
        super();
    }
    public String calcular(String num1, String num2, String op) {
        return "HelloWorld!";
    }
}
