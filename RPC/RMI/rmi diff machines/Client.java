// Client code
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try {
            // Get a reference to the remote MathService object
            Registry registry = LocateRegistry.getRegistry("localhost");
            MathService mathService = (MathService) registry.lookup("MathService");

            // Invoke the add() method on the remote object
            int result = mathService.add(10, 20);


            System.out.println("Result: " + result);
            System.out.println("Array list got is: " + mathService.arrayElements().get(0));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}