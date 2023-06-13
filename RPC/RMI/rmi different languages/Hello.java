
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
//this is the remote interface
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    void calc(int a,int b) throws RemoteException;
    ArrayList<String> arrayElements() throws RemoteException;

}
