import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws RemoteException {
        super();
    }
    public String sayHello(String userName) throws RemoteException {
        return "Server Response: Hello, "+userName+"!";
    }
}
