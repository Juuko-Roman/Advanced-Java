import java.net.*;
import java.io.*;

class Client{
	public static void main(String[] args)throws Exception {
		String recvd =null;
		DatagramSocket ss=new DatagramSocket();
		DatagramPacket pktSent=null;
		DatagramPacket pktRcvd=null;
		byte[] byteArray =new byte[1024];

		while(true){
			byteArray="login".getBytes();
			pktSent=new DatagramPacket(byteArray,byteArray.length, InetAddress.getByName("localhost"),5000);
			ss.send(pktSent);

			pktRcvd=new DatagramPacket(byteArray,byteArray.length);
			ss.receive(pktRcvd);
			recvd=new String(byteArray,"UTF-8");
			System.out.println("received data is .."+recvd);
		
		}

		

		// socket.close();
		// dos.close();
	}
}