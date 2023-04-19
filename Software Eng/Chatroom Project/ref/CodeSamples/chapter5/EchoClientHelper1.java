import java.net.*;
import java.io.*;

/**
 * This class is a module which provides the application logic
 * for an Echo client using connectionless datagram socket.
 * @author M. L. Liu
 */
public class EchoClientHelper1 {
   private MyClientDatagramSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;

   EchoClientHelper1(String hostName, String portNum) 
      throws SocketException, UnknownHostException { 
  	   this.serverHost = InetAddress.getByName(hostName);
  		this.serverPort = Integer.parseInt(portNum);
      // instantiates a datagram socket for both sending
      // and receiving data
   	this.mySocket = new MyClientDatagramSocket(); 
   } 
	
   public String getEcho( String message) 
      throws SocketException, IOException {                                                                                 
      String echo = "";    
      mySocket.sendMessage( serverHost, serverPort, message);
	   // now receive the echo
      echo = mySocket.receiveMessage();
      return echo;
   } //end getEcho

   public void done( ) throws SocketException {
      mySocket.close( );
   }  //end done

} //end class
