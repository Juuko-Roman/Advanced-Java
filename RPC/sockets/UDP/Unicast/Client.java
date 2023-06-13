import java.net.*;
import java.io.*;

class Client{
	public static void main(String[] args)throws Exception {
		String recvd =null;
		DatagramSocket ss=new DatagramSocket();
		DatagramPacket pktSent=null;
		DatagramPacket pktRcvd=null;

		while(true){
			byte[] byteArray =new byte[1024];

			//sending to server asking for allow login
			String msg="login";
			byteArray=msg.getBytes();
			pktSent=new DatagramPacket(byteArray,msg.length(), InetAddress.getByName("localhost"),4000);
			ss.send(pktSent);

			//receiving response from server about allow login
			byte[] byteArrayRecvd =new byte[1024];
			pktRcvd=new DatagramPacket(byteArrayRecvd,byteArrayRecvd.length);
			ss.receive(pktRcvd);
			byteArrayRecvd=pktRcvd.getData();
			recvd=new String(byteArrayRecvd,0,pktRcvd.getLength(),"UTF-8");
			System.out.println("received data is .."+recvd);
		}
		// socket.close();
		// dos.close();
	}
}