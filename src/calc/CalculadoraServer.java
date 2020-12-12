package calc;

//import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraServer {
    public static void main (String args [ ]) {
        
        try {
        	
            Registry registry = LocateRegistry.createRegistry(10999);

            CalculadoraImpl obj = new CalculadoraImpl();
            registry.rebind("CalculadoraServer", obj);
//            System.out.println("Calculadora rodando.");
        } catch(Exception e) {
            System.out.println("HelloServer erro"+ e.getMessage());
        }
    }
}
