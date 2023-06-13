import java.net.*;
import java.io.*;

class Client{
	public static void main(String[] args)throws Exception {
		Socket socket=new Socket("localhost",5000);
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("Divine");
		socket.close();
		dos.close();
	}
}