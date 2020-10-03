package simple_tcp;

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

    outSocket.println("Welcome!"); // First welcome message to client
    String message = inSocket.readLine();
    System.out.println("simple_tcp.Client says " + message);

    socket.close();
    System.out.println("Socket is closed!");
  }

  public static void main(String[] args) {
    try{
      new Server();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
