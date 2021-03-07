package CSE389;

import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoServer {

 // private static final int BUFSIZE = 32;   // Size of receive buffer
  
  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    // Create a server socket to accept client connection requests
    ServerSocket servSock = new ServerSocket(servPort);
    int buffSize = 32;
    int recvMsgSize;   // Size of received message
    byte[] receiveBuf = new byte[buffSize];  // Receive buffer

    while (true) { // Run forever, accepting and servicing connections
      Socket clntSock = servSock.accept();     // Get client connection

      SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
      System.out.println("Handling client at " + clientAddress);
      
      InputStream in = clntSock.getInputStream();
      OutputStream out = clntSock.getOutputStream();

      // Receive until client closes connection, indicated by -1 return
      
      do {
    	  System.out.println("connection initiated " + clientAddress);
    	  recvMsgSize = in.read(receiveBuf);
    	  System.out.println("recvMsgSize is: " + recvMsgSize);
    	  out.write(receiveBuf, 0, recvMsgSize);
    	  buffSize *= 2;
    	  receiveBuf = new byte[buffSize];
    	  
      }while((recvMsgSize = in.read(receiveBuf)) != -1);
      System.out.println("connection closed" + clientAddress);
      clntSock.close();  // Close the socket.  We are done with this client!
      buffSize = 32;
      receiveBuf = new byte[buffSize];

    }
    /* NOT REACHED */
  }
}