import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            HelloImpl obj = new HelloImpl();

            // Create and start the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            Naming.rebind("Hello", obj);
            System.out.println("Server started...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}