import java.net.*;
import java.io.*;

class Server{
	public static void main(String[] args)throws Exception {
		ServerSocket ss=new ServerSocket(5000);
		Socket socket=ss.accept();
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		String receivedData=(String)dis.readUTF();
		System.out.println("received data is .."+receivedData);	
	}
}