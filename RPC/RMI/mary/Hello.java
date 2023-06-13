
import java.rmi.Remote;
import java.rmi.RemoteException;

//this is the remote interface
public interface Hello extends Remote {
    String sayHello(String userName) throws RemoteException;
}
