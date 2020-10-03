package multithreaded_tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

  private int numClient = 1;

  public ServerMain() throws Exception {
    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("Port 8080 is open.");

    while (true) {
      Socket socket = serverSocket.accept();
      ServerThread serverThread = new ServerThread(socket, this);
      Thread thread = new Thread(serverThread);
      thread.setName(Thread.currentThread().getName() + "-child");
      thread.start();
    }
  }

  public int getNumClient() {
    return numClient++;
  }

  public static void main(String[] args) {
    try {
      new ServerMain();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
