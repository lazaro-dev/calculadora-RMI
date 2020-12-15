package calc;

import java.rmi.*;

import javax.swing.JOptionPane;

public class CalculadoraClient {
    public static void main(String args[ ]) {
        
        try {
        	String val = "";
        	String op = "";
        	String num1 = "";
        	String num2 = "";            
            do {
			
	            do {            	
	            	op = JOptionPane.showInputDialog(
	            			"Escolha uma operação: \n"
	            			+ "[+] soma \n"
	            			+ "[-] subtração \n "
	            			+ "[/] divisão \n "
	            			+ "[*] multiplicação \n "
	            			+ "[%] porcentagem \n "
	            			+ "[r] raiz (qualquer indice)\n "
	            			+ "[#] potencia");
	            	
	            	if(!op.matches("[+-/*%r#]"))//validação de string//            		
	            		JOptionPane.showMessageDialog(null, "Opção invalida");
	            }while(!op.matches("[+-/*%r#]"));
	            
	            do {            	
	            	num1 = JOptionPane.showInputDialog("Digite o primeiro número: ");
	            	if(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"))//validação de numero real e inteiro            		
	            		JOptionPane.showMessageDialog(null, "Número incorreto");
	            }while(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"));
	            
	            do {            	
	            	num2 = JOptionPane.showInputDialog("Digite o segundo número: ");
	            	if(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"))//validação de numero real e inteiro            		
	            		JOptionPane.showMessageDialog(null, "Número incorreto");
	            }while(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"));
	            
	            Calculadora obj = (Calculadora)Naming.lookup("rmi://localhost:10999/CalculadoraServer");           
	            JOptionPane.showMessageDialog(null, "Resultado = " + obj.calcular(num1, num2, op));
	            
	            val = JOptionPane.showInputDialog(null, "Para sair digite s ou qualquer tecla para continuar");
	            
            } while (!val.equals("s"));
        } catch(Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
        System.exit(0);
    }
}