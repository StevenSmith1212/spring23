import java.net.*;
import java.io.*;

/**
 * This class is a module which provides the application logic
 * for an Echo client using connectionless datagram socket.
 * @author M. L. Liu
 */
public class EchoClientHelper2 {
   private MyStreamSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;
   static final String endMessage = ".";

   EchoClientHelper2(String hostName, String portNum) 
      throws SocketException, UnknownHostException, IOException { 
	   
  	   this.serverHost = InetAddress.getByName(hostName);
  		this.serverPort = Integer.parseInt(portNum);
      // instantiates a datagram socket for both sending
      // and receiving data
  		
   	this.mySocket = new MyStreamSocket(this.serverHost, this.serverPort); 
   	System.out.println("connection request made");
   } 
	
   public String getEcho( String message)  
      throws SocketException, IOException {                                                                                 
      String echo = "";    
      mySocket.sendMessage( message);
	   // now receive the echo
      echo = mySocket.receiveMessage();
      return echo;
   } //end getEcho

   public void done( ) throws SocketException, IOException {
      mySocket.sendMessage(endMessage);
      mySocket.close();
   }  //end done

} //end class
