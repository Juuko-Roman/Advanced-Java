import java.net.*;
import java.io.*;

class Server{
	public static String login(String auth){
		String response ="not authenticated";
		switch (auth){
		case "login":
			response= "extra extrasss";
			break;
		}
		return response;
	}
	public static void main(String[] args)throws Exception {
		System.out.println("server started ..");
		DatagramSocket ss=new DatagramSocket(4000);
		DatagramPacket pktSent=null;
		DatagramPacket pktRcvd=null;
		String recvdData=null;

		while(true){
				//receiving from client
				byte[] byteArrayRecvd =new byte[1024];
				pktRcvd=new DatagramPacket(byteArrayRecvd,byteArrayRecvd.length);
				ss.receive(pktRcvd);
				byteArrayRecvd=pktRcvd.getData();
				recvdData=new String(byteArrayRecvd,0,pktRcvd.getLength(),"UTF-8");
				System.out.println("recvdData data is .. "+recvdData);
		
				//perform login operations and respond to client
				byte[] byteArraySent =new byte[1024];
				String response=login(recvdData);
				byteArraySent=response.getBytes();
				pktSent=new DatagramPacket(byteArraySent,byteArraySent.length,pktRcvd.getAddress(),pktRcvd.getPort());
				ss.send(pktSent);
			}
			
	}
}