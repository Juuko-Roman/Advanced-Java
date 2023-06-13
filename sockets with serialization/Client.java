import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String receiverIp = "127.0.0.1"; // IP address of the receiving machine
        int receiverPort = 3030; // Port number to use

        try {
            // Establish a connection
            Socket socket = new Socket(receiverIp, receiverPort);

            // Create an ObjectOutputStream
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            // Create an instance of the object to send
            MyObject objectToSend = new MyObject("Caterpillar");

            // Serialize and send the object
            outputStream.writeObject(objectToSend);

            // Close the streams and socket
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
