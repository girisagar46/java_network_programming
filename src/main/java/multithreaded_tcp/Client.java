package multithreaded_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public Client() throws Exception {
    Socket socket = new Socket("localhost", 8080);
    System.out.println("Successful connection to server!");

    // IO buffers
    BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

    Scanner input = new Scanner(System.in);

    String message = inSocket.readLine();
    System.out.println("Server says: " + message);
    message = input.nextLine();
    outSocket.println(message);

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
