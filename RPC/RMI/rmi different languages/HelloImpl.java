import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
    public void calc(int a,int b) throws RemoteException {
        System.out.println("sum is "+(a+b) );
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
