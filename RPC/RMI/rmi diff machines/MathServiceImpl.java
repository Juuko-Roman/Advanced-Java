// Remote object implementation
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MathServiceImpl extends UnicastRemoteObject implements MathService {
    public MathServiceImpl() throws RemoteException {
        super();
    }
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    public ArrayList<String> arrayElements() throws RemoteException{
        ArrayList<String> cars = new ArrayList<String>(); 
        for (int i=0;i<10;i++){
          cars.add(i+"");
          System.out.println(cars.get(i));
        }
        return cars;
    }
}