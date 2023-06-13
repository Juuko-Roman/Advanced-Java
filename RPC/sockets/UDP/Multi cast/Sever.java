import java.net.*;
import java.io.*;

class Server{
	public static String login(String auth){
		String response =null;
		switch (auth){
		case "login":
			response= "Logging in...";
			break;

		}
		return response;
	}
	public static void main(String[] args)throws Exception {
		System.out.println("server started ..");
		DatagramSocket ss=new DatagramSocket(5000);
		DatagramPacket pktSent=null;
		DatagramPacket pktRcvd=null;
		
		String recvdData=null;

		while(true){
				byte[] byteArray =new byte[1024];
				pktRcvd=new DatagramPacket(byteArray,byteArray.length);
				ss.receive(pktRcvd);
				byteArray=pktRcvd.getData();
				recvdData=new String(byteArray,0,pktRcvd.getLength());
				System.out.println("received data is .."+recvdData);
		
				String response=login(recvdData);
				byteArray=response.getBytes();
				pktSent=new DatagramPacket(byteArray,byteArray.length,pktRcvd.getAddress(),pktRcvd.getPort());
				ss.send(pktSent);
			}
			
	}
}