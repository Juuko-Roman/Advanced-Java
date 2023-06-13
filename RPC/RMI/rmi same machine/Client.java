import java.rmi.Naming;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        //GET USER INPUT
        System.out.print("enter your name: ");
        Scanner sc=new Scanner(System.in);
        String userName=sc.nextLine();

        try {
            // Look up the remote object. obj is the stub
            Hello obj = (Hello) Naming.lookup("rmi://localhost/Hello");

            // Invoke the remote method
            String message = obj.sayHello(userName);
            System.out.println(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}