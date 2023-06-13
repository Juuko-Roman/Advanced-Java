import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

class BroadcastClient {
    public static void main(String[] args) {
        try {
            int port = 8888;
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message from server: " + receivedMessage);

            socket.leaveGroup(group);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
