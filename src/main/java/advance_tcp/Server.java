package advance_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public Server() throws IOException {

    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("Port 8080 is open...");

    Socket socket = serverSocket.accept();
    System.out.println("simple_tcp.Client " + socket.getInetAddress() + " has connected.");

    // IO buffers
    BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

    int secretNum = (int) (Math.random() * 10 + 1);
    String message;

    do {
      outSocket.println("Guess a number [1-10]");
      message = inSocket.readLine();
    } while (secretNum != Integer.parseInt(message));

    outSocket.println("You got it!");
    System.out.println("Secret number is: " + secretNum + ". Exiting the server!");

    socket.close();
    System.out.println("Socket is closed!");
  }

  public static void main(String[] args) {
    try {
      new Server();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
