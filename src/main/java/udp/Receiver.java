package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {
  public Receiver() throws Exception {
    DatagramSocket socket = new DatagramSocket(8080);
    System.out.println("Receiver is running");
    Scanner input = new Scanner(System.in);

    byte[] buffer = new byte[1500]; // 1500 is MTU
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
    socket.receive(packet); // our message will be stored in `packet` object
    String message = new String(buffer).trim();
    System.out.println("Received: " + message);

    InetAddress senderAddress = packet.getAddress();
    int senderPort = packet.getPort();

    System.out.println("Type message to send.");
    message = input.nextLine();
    buffer = message.getBytes();

    packet = new DatagramPacket(buffer, buffer.length, senderAddress, senderPort);
    socket.send(packet);

    System.out.println("Sent: " + message);
  }

  public static void main(String[] args) {
    try {
      new Receiver();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
