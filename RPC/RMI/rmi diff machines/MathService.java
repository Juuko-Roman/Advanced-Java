// Remote interface
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MathService extends Remote {
    int add(int a, int b) throws RemoteException;
    ArrayList<String> arrayElements() throws RemoteException;
}