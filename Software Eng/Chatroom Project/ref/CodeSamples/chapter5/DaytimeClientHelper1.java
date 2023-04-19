
import java.net.*;

/**
 * This class is a module which provides that application logic
 * for a Daytime Client.
 * @author M. L. Liu
 */
public class DaytimeClientHelper1 {
	
   public static String getTimestamp(String hostName,
                                     String portNum){  
   
      String timestamp = ""; 
      try {      
  		    InetAddress serverHost = InetAddress.getByName(hostName);
  		    int serverPort = Integer.parseInt(portNum);
          // instantiates a datagram socket for both sending
          // and receiving data
   	    MyDatagramSocket mySocket = new MyDatagramSocket();  
          mySocket.sendMessage( serverHost, serverPort, "");
			 // now receive the timestamp
          timestamp = mySocket.receiveMessage();
		    mySocket.close( );

       } // end try
	    catch (Exception ex) {
         System.out.println("There is a problem: " + ex);
	    }
       return timestamp;
   } //end getTimeStamp 
} //end class
