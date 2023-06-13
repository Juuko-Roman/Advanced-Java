import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int portNumber = 3030; // Port number to listen on

        try {
            // Create a ServerSocket to listen for connections
            ServerSocket serverSocket = new ServerSocket(portNumber);

            // Accept a connection
            Socket socket = serverSocket.accept();

            // Create an ObjectInputStream
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Receive the object
            MyObject receivedObject = (MyObject) inputStream.readObject();

            // Process the received object
            System.out.println("Received object: " + receivedObject.greet());

            // Close the streams and socket
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
