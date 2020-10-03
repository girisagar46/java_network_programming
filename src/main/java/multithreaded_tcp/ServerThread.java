package multithreaded_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

  private final Socket socket;
  private final ServerMain serverMain;

  public ServerThread(Socket socket, ServerMain serverMain) {
    this.socket = socket;
    this.serverMain = serverMain;
  }

  @Override
  public void run() {
    try {
      int clientNum = serverMain.getNumClient();

      System.out.println("Client " + clientNum + " has connected!");
      // IO buffers
      BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter outSocket =
          new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

      outSocket.println("Welcome! " + clientNum + ". What's your name?");
      String message = inSocket.readLine();
      System.out.println("simple_tcp.Client says " + message);

      socket.close();
      System.out.println("Client " + clientNum + " is disconnected!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
