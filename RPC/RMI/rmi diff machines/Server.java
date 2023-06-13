// Server code
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create the MathService object
            MathService mathService = new MathServiceImpl();

            // Create the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the MathService object to the registry
            registry.bind("MathService", mathService);

            System.out.println("Server ready...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}