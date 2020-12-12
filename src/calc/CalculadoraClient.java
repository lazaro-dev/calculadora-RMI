package calc;

import java.rmi.*;

import javax.swing.JOptionPane;


public class CalculadoraClient {
    public static void main(String args[ ]) {
        
    	//Obs: 
        try {
        	String op = "";
        	String num1 = "";
        	String num2 = "";            
            
            do {            	
            	op = JOptionPane.showInputDialog("Escolha uma opera��o: + - / * ");
            	
            	if(!op.matches("[+|-|/\\*]"))//valida��o de string
            		JOptionPane.showMessageDialog(null, "Op��o invalida");
            }while(!op.matches("[+|-|/\\*]"));
            
            do {            	
            	num1 = JOptionPane.showInputDialog("Digite o primeiro n�mero: ");
            	if(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"))//valida��o de numero real e inteiro            		
            		JOptionPane.showMessageDialog(null, "N�mero correto");
            }while(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"));
            
            do {            	
            	num2 = JOptionPane.showInputDialog("Digite o segundo n�mero: ");
            	if(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"))//valida��o de numero real e inteiro            		
            		JOptionPane.showMessageDialog(null, "N�mero incorreto");
            }while(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"));
            
            Calculadora obj = (Calculadora)Naming.lookup("rmi://localhost:10999/CalculadoraServer");
            System.out.println(obj.calcular(num1, num2, op));
        } catch(Exception e) {
            System.out.println("HelloClient erro"+ e.getMessage());
        }
        System.exit(0);
    }
}