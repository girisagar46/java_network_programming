package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
  public Sender() throws Exception {
    DatagramSocket socket = new DatagramSocket();
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your message");
    String message = input.nextLine();
    byte[] buffer = message.getBytes();

    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 8080);
    socket.send(packet);

    System.out.println("Sent: " + message);

    buffer = new byte[1500];
    packet = new DatagramPacket(buffer, buffer.length);
    socket.receive(packet);

    message = new String(buffer).trim();
    System.out.println("Received: " + message);
  }
  public static void main(String[] args) {
    try{
      new Sender();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
