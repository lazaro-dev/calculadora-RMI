package calc;

import java.rmi.*;
public interface Calculadora extends Remote {
    String calcular(String num1, String num2, String op) throws RemoteException;

}