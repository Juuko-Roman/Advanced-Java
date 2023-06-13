import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class BroadcastServer {
    public static void main(String[] args) {
        try {
            int port = 8888;
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket();

            String message = "Broadcast message from server!";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, port);
            socket.send(sendPacket);

            System.out.println("Message sent to multicast group.");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
