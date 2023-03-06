import java.net.*;

/**
 * This class is a module which provides that application logic
 * for a Daytime Client which uses stream-mode socket for IPC.
 * @author M. L. Liu
 */

public class DaytimeClientHelper2 {
	
   public static String getTimestamp(String hostName,
      String portNum) throws Exception	{     


      String timestamp = "";      
      InetAddress serverHost = InetAddress.getByName(hostName);
      int serverPort = Integer.parseInt(portNum);
      // instantiates a stream mode socket and wait to make a 
      // connection to the server port
/**/  System.out.println("Connection request made");
      MyStreamSocket mySocket = 
      new MyStreamSocket(serverHost, serverPort); 
	   // now wait to receive the timestamp
      timestamp = mySocket.receiveMessage();
      mySocket.close( ); // disconnect is implied
      return timestamp;
   } //end 
} //end class
