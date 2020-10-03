package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  public Client() throws Exception {
    Socket socket = new Socket("localhost", 8080);
    System.out.println("Successful connection to server!");

    // IO buffers
    BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

    String message = inSocket.readLine();
    System.out.println("Server Says: " + message);

    outSocket.println("Thanks");
    socket.close();
    System.out.println("Socket closed!");
  }

  public static void main(String[] args) {
    try {
      new Client();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
