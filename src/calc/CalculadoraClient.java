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
            	op = JOptionPane.showInputDialog("Escolha uma operação: + - / * ");
            	
            	if(!op.matches("[+|-|/\\*]"))//validação de string
            		JOptionPane.showMessageDialog(null, "Opção invalida");
            }while(!op.matches("[+|-|/\\*]"));
            
            do {            	
            	num1 = JOptionPane.showInputDialog("Digite o primeiro número: ");
            	if(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"))//validação de numero real e inteiro            		
            		JOptionPane.showMessageDialog(null, "Número correto");
            }while(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"));
            
            do {            	
            	num2 = JOptionPane.showInputDialog("Digite o segundo número: ");
            	if(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"))//validação de numero real e inteiro            		
            		JOptionPane.showMessageDialog(null, "Número incorreto");
            }while(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"));
            
            Calculadora obj = (Calculadora)Naming.lookup("rmi://localhost:10999/CalculadoraServer");
            System.out.println(obj.calcular(num1, num2, op));
        } catch(Exception e) {
            System.out.println("HelloClient erro"+ e.getMessage());
        }
        System.exit(0);
    }
}