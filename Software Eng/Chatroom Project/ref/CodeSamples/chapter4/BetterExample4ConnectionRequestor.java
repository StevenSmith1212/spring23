/**************************************************************************
 An improved version of the Example4ConnectionRequestor.java -
 it takes advantage of the added "connect" method which allows a connect
 request to be decoupled from the Socket constructor, and also allows 
 a timeout on connect.
 @author M. L. Liu
**************************************************************************/
import java.net.*;
import java.io.*;

/**
 * This example illustrates the basic syntax for stream-mode
 * socket.
 * @author M. L. Liu
 */
public class Example4ConnectionRequestor {

// An application that sends a message using stream-mode socket.
// Two command line arguments are expected: 
//
//    <host name of the connection accceptor>
//    <port number of the connection accceptor>

   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
  		      InetAddress acceptorHost = InetAddress.getByName(args[0]);
  		      int acceptorPort = Integer.parseInt(args[1]);

            // instantiates a data socket and connect with a timeout
            SocketAddress sockAddr = new InetSocketAddress(acceptorHost, acceptorPort);
   	      Socket mySocket = new Socket(); 
            int  timeoutPeriod = 5000;    // 2 seconds
            mySocket.connect(sockAddr, timeoutPeriod); 
/**/        System.out.println("Connection request granted"); 
            // get an input stream for reading from the data socket
            InputStream inStream = mySocket.getInputStream();
            // create a BufferedReader object for text line input
            BufferedReader socketInput = 
               new BufferedReader(new InputStreamReader(inStream));
/**/        System.out.println("waiting to read");
            // read a line from the data stream
            String message = socketInput.readLine( );
/**/        System.out.println("Message received:");
            System.out.println("\t" + message);
            mySocket.close( );
/**/        System.out.println("data socket closed");
         } // end try
	 catch (Exception ex) {
       ex.printStackTrace( );
	 }
      } // end else
   } // end main
} // end class
