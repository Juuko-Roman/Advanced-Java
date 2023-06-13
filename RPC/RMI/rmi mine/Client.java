import java.rmi.Naming;
import java.time.LocalDate;
import java.time.LocalTime;
public class Client {
    public static void main(String[] args) {
        try {
            // Look up the remote object. obj is the stub
            Hello obj = (Hello) Naming.lookup("rmi://localhost/Hello");

            //for different network
            // Hello obj = (Hello) Naming.lookup("rmi://192.168.43.54:1099/Hello");

            // Invoke the remote method
            String message = obj.sayHello();
            LocalDate currdate = LocalDate.now(); 
            LocalTime currTime = LocalTime.now();
            System.out.println(currdate +" "+currTime+ ":- Array list got is: " + obj.arrayElements());

            System.out.println(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}