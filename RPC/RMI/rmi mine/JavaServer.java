import java.net.*;
import java.io.*;

public class JavaServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 5555;

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Client connected");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                out.println("Server received: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
