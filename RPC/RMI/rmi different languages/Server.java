import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
// import java.rmi.RMISecurityManager;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            HelloImpl obj = new HelloImpl();

             // Create and install a security manager
            // System.setSecurityManager(new RMISecurityManager());
            
            //Configure the RMI registry port
            // To configure the RMI registry port, create a new system property java.rmi.server.port 
            // and set its value to the desired port number
            System.setProperty("java.rmi.server.port", "1099");

            // Create and start the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry
            Naming.rebind("Hello", obj);//checks if binding was already done, if not it does replace the existing one

            //u can use the ip address without hardcoding as seen below
            // System.out.println("Server started");
            //  InetAddress ip = InetAddress.getLocalHost();
            // System.out.println("IP Address: " + ip.getHostAddress());
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

//NB:
// compile the file that has main since it has calls to other classes, they will also be compiled
// then run cmd start rmiregistry in windows