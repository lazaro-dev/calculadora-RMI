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
	            			"Escolha uma opera��o: \n"
	            			+ "[+] soma \n"
	            			+ "[-] subtra��o \n "
	            			+ "[/] divis�o \n "
	            			+ "[*] multiplica��o \n "
	            			+ "[%] porcentagem \n "
	            			+ "[r] raiz (qualquer indice)\n "
	            			+ "[#] potencia");
	            	
	            	if(!op.matches("[+-/*%r#]"))//valida��o de string//            		
	            		JOptionPane.showMessageDialog(null, "Op��o invalida");
	            }while(!op.matches("[+-/*%r#]"));
	            
	            do {            	
	            	num1 = JOptionPane.showInputDialog("Digite o primeiro n�mero: ");
	            	if(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"))//valida��o de numero real e inteiro            		
	            		JOptionPane.showMessageDialog(null, "N�mero incorreto");
	            }while(!num1.matches("[+-]?([0-9]*[.,])?[0-9]+"));
	            
	            do {            	
	            	num2 = JOptionPane.showInputDialog("Digite o segundo n�mero: ");
	            	if(!num2.matches("[+-]?([0-9]*[.,])?[0-9]+"))//valida��o de numero real e inteiro            		
	            		JOptionPane.showMessageDialog(null, "N�mero incorreto");
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